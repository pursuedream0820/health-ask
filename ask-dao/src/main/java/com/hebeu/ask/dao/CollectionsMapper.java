package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.Collections;
import com.hebeu.ask.model.po.CollectionsExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chendehua
 */

@Repository
public interface CollectionsMapper {
    int countByExample(CollectionsExample example);

    int deleteByExample(CollectionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Collections record);

    int insertSelective(Collections record);

    List<Collections> selectByExample(CollectionsExample example);

    Collections selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Collections record, @Param("example") CollectionsExample example);

    int updateByExample(@Param("record") Collections record, @Param("example") CollectionsExample example);

    int updateByPrimaryKeySelective(Collections record);

    int updateByPrimaryKey(Collections record);
}