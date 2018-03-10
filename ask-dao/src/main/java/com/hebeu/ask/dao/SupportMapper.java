package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.Support;
import com.hebeu.ask.model.po.SupportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chendehua
 */
@Repository
public interface SupportMapper {
    int countByExample(SupportExample example);

    int deleteByExample(SupportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Support record);

    int insertSelective(Support record);

    List<Support> selectByExample(SupportExample example);

    Support selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Support record, @Param("example") SupportExample example);

    int updateByExample(@Param("record") Support record, @Param("example") SupportExample example);

    int updateByPrimaryKeySelective(Support record);

    int updateByPrimaryKey(Support record);
}