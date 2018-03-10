package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.Migration;
import com.hebeu.ask.model.po.MigrationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chendehua
 */
@Repository
public interface MigrationMapper {
    int countByExample(MigrationExample example);

    int deleteByExample(MigrationExample example);

    int insert(Migration record);

    int insertSelective(Migration record);

    List<Migration> selectByExample(MigrationExample example);

    int updateByExampleSelective(@Param("record") Migration record, @Param("example") MigrationExample example);

    int updateByExample(@Param("record") Migration record, @Param("example") MigrationExample example);
}