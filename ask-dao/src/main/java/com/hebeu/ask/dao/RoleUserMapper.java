package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.RoleUser;
import com.hebeu.ask.model.po.RoleUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chendehua
 */
@Repository
public interface RoleUserMapper {
    int countByExample(RoleUserExample example);

    int deleteByExample(RoleUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleUser record);

    int insertSelective(RoleUser record);

    List<RoleUser> selectByExample(RoleUserExample example);

    RoleUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleUser record, @Param("example") RoleUserExample example);

    int updateByExample(@Param("record") RoleUser record, @Param("example") RoleUserExample example);

    int updateByPrimaryKeySelective(RoleUser record);

    int updateByPrimaryKey(RoleUser record);
}