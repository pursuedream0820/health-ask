package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.Credit;
import com.hebeu.ask.model.po.CreditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chendehua
 */
@Repository
public interface CreditMapper {
    int countByExample(CreditExample example);

    int deleteByExample(CreditExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Credit record);

    int insertSelective(Credit record);

    List<Credit> selectByExample(CreditExample example);

    Credit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Credit record, @Param("example") CreditExample example);

    int updateByExample(@Param("record") Credit record, @Param("example") CreditExample example);

    int updateByPrimaryKeySelective(Credit record);

    int updateByPrimaryKey(Credit record);
}