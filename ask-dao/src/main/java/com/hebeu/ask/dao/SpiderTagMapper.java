package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.SpiderTag;
import com.hebeu.ask.model.po.SpiderTagExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chendehua
 */
@Repository
public interface SpiderTagMapper {
    int countByExample(SpiderTagExample example);

    int deleteByExample(SpiderTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SpiderTag record);

    int insertSelective(SpiderTag record);

    List<SpiderTag> selectByExample(SpiderTagExample example);

    SpiderTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SpiderTag record, @Param("example") SpiderTagExample example);

    int updateByExample(@Param("record") SpiderTag record, @Param("example") SpiderTagExample example);

    int updateByPrimaryKeySelective(SpiderTag record);

    int updateByPrimaryKey(SpiderTag record);
}