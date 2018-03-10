package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.Doing;
import com.hebeu.ask.model.po.DoingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chendehua
 */
@Repository
public interface DoingMapper {
    int countByExample(DoingExample example);

    int deleteByExample(DoingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Doing record);

    int insertSelective(Doing record);

    List<Doing> selectByExample(DoingExample example);

    Doing selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Doing record, @Param("example") DoingExample example);

    int updateByExample(@Param("record") Doing record, @Param("example") DoingExample example);

    int updateByPrimaryKeySelective(Doing record);

    int updateByPrimaryKey(Doing record);
}