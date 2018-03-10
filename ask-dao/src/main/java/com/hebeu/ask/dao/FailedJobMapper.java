package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.FailedJob;
import com.hebeu.ask.model.po.FailedJobExample;
import com.hebeu.ask.model.po.FailedJobWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chendehua
 */
@Repository
public interface FailedJobMapper {
    int countByExample(FailedJobExample example);

    int deleteByExample(FailedJobExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FailedJobWithBLOBs record);

    int insertSelective(FailedJobWithBLOBs record);

    List<FailedJobWithBLOBs> selectByExampleWithBLOBs(FailedJobExample example);

    List<FailedJob> selectByExample(FailedJobExample example);

    FailedJobWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FailedJobWithBLOBs record, @Param("example") FailedJobExample example);

    int updateByExampleWithBLOBs(@Param("record") FailedJobWithBLOBs record, @Param("example") FailedJobExample example);

    int updateByExample(@Param("record") FailedJob record, @Param("example") FailedJobExample example);

    int updateByPrimaryKeySelective(FailedJobWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(FailedJobWithBLOBs record);

    int updateByPrimaryKey(FailedJob record);
}