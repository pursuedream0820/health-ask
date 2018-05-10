package com.hebeu.ask.seo.index;

import com.hebeu.ask.dao.QuestionMapper;
import com.hebeu.ask.model.enums.IndexPathEnum;
import com.hebeu.ask.model.po.Question;
import com.hebeu.ask.model.po.QuestionExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/3/9 下午10:29
 * Desc   : 索引管理类 ，负责清空索引和创建索引
 **/
@Component
@Slf4j
public class Indexer {

    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 增量创建问题索引库
     */
    public void createQuestionIndex(List<Question> questionList) {
        IndexWriter indexWriter = getIndexWriter(IndexPathEnum.QUESTION_INDEX_PATH);
        if (indexWriter == null){
            log.warn("获取到IndexWriter对象为空，停止创建索引操作");
            return;
        }
        try {
            for (Question question : questionList) {
                Document document = new Document();
                document.add(new Field("id", String.valueOf(question.getId()), TextField.TYPE_STORED));
                document.add(new Field("title", question.getTitle(), TextField.TYPE_STORED));
                document.add(new Field("description", question.getDescription(), TextField.TYPE_STORED));
                document.add(new Field("status",String.valueOf(question.getStatus()), TextField.TYPE_STORED));
                indexWriter.addDocument(document);
            }
        } catch (Exception e) {
            log.error("创建索引异常", e);
        } finally {
            try {
                indexWriter.close();
            } catch (Exception e) {
                log.error("关闭indexWriter对象异常", e);
            }
        }
    }

    /**
     * 清空索引
     *
     * @param indexPathEnum 索引地址枚举
     */
    public void clearIndex(IndexPathEnum indexPathEnum) {
        IndexWriter indexWriter = getIndexWriter(indexPathEnum);
        if (indexWriter == null) {
            log.warn("获取到IndexWriter对象为空，停止清空索引操作");
            return;
        }
        log.info("开始清空索引");
        try {
            indexWriter.deleteAll();
        } catch (IOException e) {
            log.error("清除索引异常", e);
        } finally {
            try {
                indexWriter.close();
            } catch (Exception e) {
                log.error("关闭indexWriter对象异常", e);
            }
        }
        log.info("清空索引结束");
    }


    /**
     * 根据索引库地址获取获取IndexWriter对象
     *
     * @param indexPathEnum 索引地址枚举对象
     * @return 返回对应索引的IndexWriter
     */
    private static IndexWriter getIndexWriter(IndexPathEnum indexPathEnum) {
        IndexWriter indexWriter = null;
        try {
            // 判断路径是否存在，不存在就先创建文件夹
            File file = new File(indexPathEnum.getPath());
            if (!file.exists()) {
                log.warn("文件路径不存在，path:{}", indexPathEnum.getPath());
                boolean result = file.mkdirs();
                if (result) {
                    log.info("创建文件夹成功，path:{}", indexPathEnum.getPath());
                } else {
                    log.error("创建文件夹失败， path:{}", indexPathEnum.getPath());
                    return null;
                }
            }
            Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(indexPathEnum.getPath()));
            //创建标准分词对象
            //TODO 后期改成中文分词，自定义分词器
            Analyzer analyzer = new IKAnalyzer(true);
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
            indexWriter = new IndexWriter(directory, indexWriterConfig);
        } catch (IOException e) {
            log.error("获取IndexWriter对象失败", e);
        }
        return indexWriter;
    }


}