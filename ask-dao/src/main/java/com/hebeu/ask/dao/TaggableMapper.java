package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.Taggable;
import com.hebeu.ask.model.po.TaggableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chendehua
 */
@Repository
public interface TaggableMapper {
    int countByExample(TaggableExample example);

    int deleteByExample(TaggableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Taggable record);

    int insertSelective(Taggable record);

    List<Taggable> selectByExample(TaggableExample example);

    Taggable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Taggable record, @Param("example") TaggableExample example);

    int updateByExample(@Param("record") Taggable record, @Param("example") TaggableExample example);

    int updateByPrimaryKeySelective(Taggable record);

    int updateByPrimaryKey(Taggable record);
}