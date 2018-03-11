package com.hebeu.ask.seo.search;

import com.hebeu.ask.model.enums.IndexPathEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Component;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.StringReader;
import java.nio.file.FileSystems;

/**
 * @author : chenDeHua
 * Time   : 2018/3/9 下午10:36
 * Desc   : 搜索工具类
 **/

@Component
@Slf4j
public class Searcher {

    public void searchQuestion(String keywords){

        DirectoryReader directoryReader = null;
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
            TopDocs topDocs = indexSearcher.search(multiFieldQuery, 100);
            log.info("共找到匹配处：" + topDocs.totalHits);
            // 6、根据TopDocs获取ScoreDoc对象
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            log.info("共找到匹配文档数：" + scoreDocs.length);

            // 7、把搜索记录中的关键字段设置高亮显示样式
            QueryScorer scorer = new QueryScorer(multiFieldQuery, "title");
            SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter("<span style=\"background:red\">", "</span>");
            Highlighter highlighter = new Highlighter(htmlFormatter, scorer);
            highlighter.setTextFragmenter(new SimpleSpanFragmenter(scorer));

            // 8、遍历搜索结果记录
            for (ScoreDoc scoreDoc : scoreDocs) {
                // 9、根据searcher和ScoreDoc对象获取具体的Document对象
                Document document = indexSearcher.doc(scoreDoc.doc);

                // 10、根据Document对象获取需要的值
                String title = document.get("title");
                log.info("问题标题，title:{}",title);
                log.info("问题描述，description:{}",document.get("description"));
                log.info("标题高亮，titleHighlighter:{}",highlighter.getBestFragment(analyzer, "title", title));
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

    }

}


