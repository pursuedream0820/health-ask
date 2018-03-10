package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.UserOauth;
import com.hebeu.ask.model.po.UserOauthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chendehua
 */
@Repository
public interface UserOauthMapper {
    int countByExample(UserOauthExample example);

    int deleteByExample(UserOauthExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserOauth record);

    int insertSelective(UserOauth record);

    List<UserOauth> selectByExample(UserOauthExample example);

    UserOauth selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserOauth record, @Param("example") UserOauthExample example);

    int updateByExample(@Param("record") UserOauth record, @Param("example") UserOauthExample example);

    int updateByPrimaryKeySelective(UserOauth record);

    int updateByPrimaryKey(UserOauth record);
}