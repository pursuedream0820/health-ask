package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.UserData;
import com.hebeu.ask.model.po.UserDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chendehua
 */
@Repository
public interface UserDataMapper {
    int countByExample(UserDataExample example);

    int deleteByExample(UserDataExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserData record);

    int insertSelective(UserData record);

    List<UserData> selectByExample(UserDataExample example);

    UserData selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UserData record, @Param("example") UserDataExample example);

    int updateByExample(@Param("record") UserData record, @Param("example") UserDataExample example);

    int updateByPrimaryKeySelective(UserData record);

    int updateByPrimaryKey(UserData record);
}