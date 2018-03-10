package com.hebeu.ask.dao;

import com.hebeu.ask.model.po.QuestionInvitation;
import com.hebeu.ask.model.po.QuestionInvitationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chendehua
 */
@Repository
public interface QuestionInvitationMapper {
    int countByExample(QuestionInvitationExample example);

    int deleteByExample(QuestionInvitationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QuestionInvitation record);

    int insertSelective(QuestionInvitation record);

    List<QuestionInvitation> selectByExample(QuestionInvitationExample example);

    QuestionInvitation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QuestionInvitation record, @Param("example") QuestionInvitationExample example);

    int updateByExample(@Param("record") QuestionInvitation record, @Param("example") QuestionInvitationExample example);

    int updateByPrimaryKeySelective(QuestionInvitation record);

    int updateByPrimaryKey(QuestionInvitation record);
}