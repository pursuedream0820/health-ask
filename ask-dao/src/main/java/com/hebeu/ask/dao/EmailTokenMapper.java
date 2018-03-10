package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.EmailToken;
import com.hebeu.ask.model.po.EmailTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chendehua
 */
@Repository
public interface EmailTokenMapper {
    int countByExample(EmailTokenExample example);

    int deleteByExample(EmailTokenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmailToken record);

    int insertSelective(EmailToken record);

    List<EmailToken> selectByExample(EmailTokenExample example);

    EmailToken selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmailToken record, @Param("example") EmailTokenExample example);

    int updateByExample(@Param("record") EmailToken record, @Param("example") EmailTokenExample example);

    int updateByPrimaryKeySelective(EmailToken record);

    int updateByPrimaryKey(EmailToken record);
}