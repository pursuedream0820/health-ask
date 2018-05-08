package com.hebeu.ask.seo.search;

import com.hebeu.ask.model.enums.IndexPathEnum;
import com.hebeu.ask.model.vo.SearchResultVo;
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

    public List<SearchResultVo> searchQuestion(String keywords) {

        DirectoryReader directoryReader = null;
        List<SearchResultVo> searchResultVoList = new ArrayList<>();

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
            // 搜索前100条结果
            TopDocs topDocs = indexSearcher.search(multiFieldQuery, 1000);
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

                log.debug("问题id，id:{}", document.get("id"));
                log.debug("问题标题，title:{}", title);
                log.debug("问题描述，description:{}", description);
                log.debug("标题高亮，titleHighlighter:{}", titleHighlight);
                log.debug("标题描述高亮：descHighlighter:{}", descHighlight);
                log.debug("问题状态，status：{}", status);

                SearchResultVo searchResultVo = SearchResultVo.builder()
                        .id(Integer.valueOf(id))
                        .title(title)
                        .description(description)
                        .titleHighlighter(StringUtils.isEmpty(titleHighlight) ? title : titleHighlight)
                        .descHighlighter(StringUtils.isEmpty(descHighlight) ? description : descHighlight)
                        .status(Integer.valueOf(status))
                        .build();
                log.debug("搜索结果对象：{}", searchResultVo.toString());
                searchResultVoList.add(searchResultVo);
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

        return searchResultVoList;

    }

}


