package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.SpiderKeyword;
import com.hebeu.ask.model.po.SpiderKeywordExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chendehua
 */
@Repository
public interface SpiderKeywordMapper {
    int countByExample(SpiderKeywordExample example);

    int deleteByExample(SpiderKeywordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SpiderKeyword record);

    int insertSelective(SpiderKeyword record);

    List<SpiderKeyword> selectByExample(SpiderKeywordExample example);

    SpiderKeyword selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SpiderKeyword record, @Param("example") SpiderKeywordExample example);

    int updateByExample(@Param("record") SpiderKeyword record, @Param("example") SpiderKeywordExample example);

    int updateByPrimaryKeySelective(SpiderKeyword record);

    int updateByPrimaryKey(SpiderKeyword record);
}