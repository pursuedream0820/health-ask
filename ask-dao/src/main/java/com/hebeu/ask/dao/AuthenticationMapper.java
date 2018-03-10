package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.Authentication;
import com.hebeu.ask.model.po.AuthenticationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chendehua
 */
@Repository
public interface AuthenticationMapper {
    int countByExample(AuthenticationExample example);

    int deleteByExample(AuthenticationExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(Authentication record);

    int insertSelective(Authentication record);

    List<Authentication> selectByExampleWithBLOBs(AuthenticationExample example);

    List<Authentication> selectByExample(AuthenticationExample example);

    Authentication selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") Authentication record, @Param("example") AuthenticationExample example);

    int updateByExampleWithBLOBs(@Param("record") Authentication record, @Param("example") AuthenticationExample example);

    int updateByExample(@Param("record") Authentication record, @Param("example") AuthenticationExample example);

    int updateByPrimaryKeySelective(Authentication record);

    int updateByPrimaryKeyWithBLOBs(Authentication record);

    int updateByPrimaryKey(Authentication record);
}