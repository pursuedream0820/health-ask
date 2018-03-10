package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.Setting;
import com.hebeu.ask.model.po.SettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chendehua
 */
@Repository
public interface SettingMapper {
    int countByExample(SettingExample example);

    int deleteByExample(SettingExample example);

    int deleteByPrimaryKey(String name);

    int insert(Setting record);

    int insertSelective(Setting record);

    List<Setting> selectByExampleWithBLOBs(SettingExample example);

    List<Setting> selectByExample(SettingExample example);

    Setting selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") Setting record, @Param("example") SettingExample example);

    int updateByExampleWithBLOBs(@Param("record") Setting record, @Param("example") SettingExample example);

    int updateByExample(@Param("record") Setting record, @Param("example") SettingExample example);

    int updateByPrimaryKeySelective(Setting record);

    int updateByPrimaryKeyWithBLOBs(Setting record);
}