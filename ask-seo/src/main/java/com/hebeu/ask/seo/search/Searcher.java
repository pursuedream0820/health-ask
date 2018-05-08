package com.hebeu.ask.seo.search;

import com.hebeu.ask.model.enums.IndexPathEnum;
import com.hebeu.ask.model.vo.QuestionVo;
import org.apache.commons.lang3.tuple.Pair;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Component;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/3/9 下午10:36
 * Desc   : 搜索工具类
 **/

@Component
@Slf4j
public class Searcher {


    /**
     * @param keywords 关键词
     * @param pageNum  查询页码
     * @param pageSize 页码大小
     * @return 返回对应页码结果和总数
     */
    public Pair<List<QuestionVo>, Integer> searchQuestion(String keywords, Integer pageNum, Integer pageSize) {

        DirectoryReader directoryReader = null;
        List<QuestionVo> searchQuestionVoList = new ArrayList<>();
        Integer count = 0;

        try {
            // 1、创建Directory
            Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(IndexPathEnum.QUESTION_INDEX_PATH.getPath()));
            // 2、创建IndexReader
            directoryReader = DirectoryReader.open(directory);
            // 3、根据IndexReader创建IndexSearch
            IndexSearcher indexSearcher = new IndexSearcher(directoryReader);
            // 4、创建搜索的Query
            // 使用IK分词
            Analyzer analyzer = new IKAnalyzer(true);

            String[] fields = {"title", "description"};
            // MUST 表示and，MUST_NOT 表示not ，SHOULD表示or
            BooleanClause.Occur[] clauses = {BooleanClause.Occur.SHOULD, BooleanClause.Occur.SHOULD};
            // MultiFieldQueryParser表示多个域解析， 同时可以解析含空格的字符串，如果我们搜索"上海 中国"
            Query multiFieldQuery = MultiFieldQueryParser.parse(keywords, fields, clauses, analyzer);

            // 5、根据searcher搜索并且返回TopDocs
            // 搜索前1000条结果
            count = indexSearcher.count(multiFieldQuery);
            log.debug("查询到的记录数为count:{}", count);
            //获取上一页的最后一个元素
            ScoreDoc lastScoreDoc = getLastScoreDoc(pageNum, pageSize, multiFieldQuery, indexSearcher);
            //通过最后一个元素搜索下页的pageSize个元素
            TopDocs topDocs = indexSearcher.searchAfter(lastScoreDoc, multiFieldQuery, pageSize);
            log.info("共找到匹配处：" + topDocs.totalHits);
            // 6、根据TopDocs获取ScoreDoc对象
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            log.info("共找到匹配文档数：" + scoreDocs.length);

            // 7、把搜索记录中的关键字段设置高亮显示样式
            QueryScorer titleScorer = new QueryScorer(multiFieldQuery, "title");
            QueryScorer descScorer = new QueryScorer(multiFieldQuery, "description");

            SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter("<em>", "</em>");

            Highlighter titleHighlighter = new Highlighter(htmlFormatter, titleScorer);
            titleHighlighter.setTextFragmenter(new SimpleSpanFragmenter(titleScorer));

            Highlighter descHighlighter = new Highlighter(htmlFormatter, descScorer);
            descHighlighter.setTextFragmenter(new SimpleSpanFragmenter(descScorer));

            // 8、遍历搜索结果记录
            for (ScoreDoc scoreDoc : scoreDocs) {
                // 9、根据searcher和ScoreDoc对象获取具体的Document对象
                Document document = indexSearcher.doc(scoreDoc.doc);

                // 10、根据Document对象获取需要的值
                String id = document.get("id");
                String title = document.get("title");
                String description = document.get("description");
                String status = document.get("status");
                String titleHighlight = titleHighlighter.getBestFragment(analyzer, "title", title);
                String descHighlight = descHighlighter.getBestFragment(analyzer, "description", document.get("description"));

                log.debug("问题id，id:{}", id);
                log.debug("问题标题，title:{}", title);
                log.debug("问题描述，description:{}", description);
                log.debug("标题高亮，titleHighlighter:{}", titleHighlight);
                log.debug("标题描述高亮：descHighlighter:{}", descHighlight);
                log.debug("问题状态，status：{}", status);

                QuestionVo searchResultVo = new QuestionVo();
                searchResultVo.setId(Integer.valueOf(id));
                searchResultVo.setTitle(title);
                searchResultVo.setDescription(description);
                searchResultVo.setTitleHighlighter(StringUtils.isEmpty(titleHighlight) ? title : titleHighlight);
                searchResultVo.setDescHighlighter(StringUtils.isEmpty(descHighlight) ? description : descHighlight);
                searchResultVo.setStatus(Integer.valueOf(status));
                log.debug("搜索结果对象：{}", searchResultVo.toString());
                searchQuestionVoList.add(searchResultVo);
            }
        } catch (Exception e) {
            log.error("搜索异常", e);
        } finally {
            try {
                if (directoryReader != null) {
                    directoryReader.close();
                }
            } catch (Exception e) {
                log.error("关闭directoryReader对象异常", e);
            }
        }

        return Pair.of(searchQuestionVoList, count);

    }


    /**
     * 根据页码和分页大小获取上一次最后一个ScoreDoc
     *
     * @param pageIndex     查询页码值
     * @param pageSize      页码大小
     * @param query         查询对象
     * @param indexSearcher 搜索对象
     * @return 返回上一页
     * @throws IOException io异常
     */
    private ScoreDoc getLastScoreDoc(int pageIndex, int pageSize, Query query, IndexSearcher indexSearcher) throws IOException {
        //如果是第一页返回空
        if (pageIndex == 1) {
            return null;
        }
        //获取上一页的数量
        int num = pageSize * (pageIndex - 1);
        TopDocs tds = indexSearcher.search(query, num);
        return tds.scoreDocs[num - 1];
    }

}


