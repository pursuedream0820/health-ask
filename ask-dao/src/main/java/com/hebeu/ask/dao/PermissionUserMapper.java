package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.PermissionUser;
import com.hebeu.ask.model.po.PermissionUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chendehua
 */
@Repository
public interface PermissionUserMapper {
    int countByExample(PermissionUserExample example);

    int deleteByExample(PermissionUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PermissionUser record);

    int insertSelective(PermissionUser record);

    List<PermissionUser> selectByExample(PermissionUserExample example);

    PermissionUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PermissionUser record, @Param("example") PermissionUserExample example);

    int updateByExample(@Param("record") PermissionUser record, @Param("example") PermissionUserExample example);

    int updateByPrimaryKeySelective(PermissionUser record);

    int updateByPrimaryKey(PermissionUser record);
}