package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.SpiderLog;
import com.hebeu.ask.model.po.SpiderLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpiderLogMapper {
    int countByExample(SpiderLogExample example);

    int deleteByExample(SpiderLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SpiderLog record);

    int insertSelective(SpiderLog record);

    List<SpiderLog> selectByExample(SpiderLogExample example);

    SpiderLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SpiderLog record, @Param("example") SpiderLogExample example);

    int updateByExample(@Param("record") SpiderLog record, @Param("example") SpiderLogExample example);

    int updateByPrimaryKeySelective(SpiderLog record);

    int updateByPrimaryKey(SpiderLog record);
}