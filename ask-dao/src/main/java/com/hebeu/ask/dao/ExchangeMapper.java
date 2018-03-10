package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.Exchange;
import com.hebeu.ask.model.po.ExchangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chendehua
 */
@Repository
public interface ExchangeMapper {
    int countByExample(ExchangeExample example);

    int deleteByExample(ExchangeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Exchange record);

    int insertSelective(Exchange record);

    List<Exchange> selectByExample(ExchangeExample example);

    Exchange selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Exchange record, @Param("example") ExchangeExample example);

    int updateByExample(@Param("record") Exchange record, @Param("example") ExchangeExample example);

    int updateByPrimaryKeySelective(Exchange record);

    int updateByPrimaryKey(Exchange record);
}