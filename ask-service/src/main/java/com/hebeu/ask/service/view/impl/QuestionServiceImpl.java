package com.hebeu.ask.service.view.impl;

import com.github.pagehelper.PageHelper;
import com.hebeu.ask.dao.*;
import com.hebeu.ask.model.enums.QuestionTypeEnum;
import com.hebeu.ask.model.po.*;
import com.hebeu.ask.model.po.Collections;
import com.hebeu.ask.model.vo.QuestionVo;
import com.hebeu.ask.service.view.QuestionService;
import com.hebeu.ask.util.DateUtil;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author : chenDeHua
 * Time   : 2018/3/10 下午7:22
 * Desc   :
 **/
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private DoingMapper doingMapper;

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private UserDataMapper userDataMapper;

    @Autowired
    private CollectionsMapper collectionsMapper;

    @Autowired
    private AttentionMapper attentionMapper;


    /**
     * 查询最新问题
     *
     * @return 返回最新问题集合
     */
    @Override
    public List<Question> queryNewQuestion(Integer queryNum) {
        PageHelper.startPage(1, queryNum, "created_at desc");
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andIdIsNotNull();
        return questionMapper.selectByExample(questionExample);
    }

    /**
     * 查询悬赏问题
     *
     * @param queryNum 查询数量
     * @return 返回悬赏问题集合
     */
    @Override
    public List<Question> queryAwardQuestion(Integer queryNum) {
        PageHelper.startPage(1, queryNum, "created_at desc");
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andIdIsNotNull();
        criteria.andPriceGreaterThan(Short.parseShort("0"));
        return questionMapper.selectByExample(questionExample);
    }

    /**
     * 更新浏览次数
     *
     * @param id 问题id
     */
    @Override
    public void updateViews(Integer id, Question question) {
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andIdEqualTo(id);
        question.setViews(question.getViews() + 1);
        questionMapper.updateByExampleSelective(question, questionExample);
    }


    /**
     * 根据id查询问题详情
     *
     * @param id 问题id
     * @return 返回查询的问题详情
     */
    @Override
    public QuestionVo queryDetailById(Integer id) {
        Question question = questionMapper.selectByPrimaryKey(id);

        QuestionVo questionVo = new QuestionVo();
        BeanUtils.copyProperties(question, questionVo);
        questionVo.setCreateTime(DateUtil.dateToString(DateUtil.yyyy_MM_dd_HH_mm_ss, question.getCreatedAt()));

        // 设置用户姓名和id
        User user = userMapper.selectByPrimaryKey(question.getUserId());
        questionVo.setUserName(user.getName());
        questionVo.setUserId(user.getId());

        return questionVo;
    }

    /**
     * 更新问题回答数
     *
     * @param id 问题id
     */
    @Override
    public void updateAnswers(Integer id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        question.setAnswers(question.getAnswers() + 1);

        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andIdEqualTo(id);

        questionMapper.updateByExampleSelective(question, questionExample);
    }

    /**
     * 查询所有的分类
     *
     * @return 返回分类集合
     */
    @Override
    public List<Category> queryCategory() {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        criteria.andIdIsNotNull();
        return categoryMapper.selectByExample(categoryExample);
    }

    /**
     * 保存问题
     *
     * @param question 问题对象
     * @return 返回操作结果
     */
    @Override
    public boolean saveQuestion(Question question) {
        Integer result = questionMapper.insertSelective(question);
        Doing doing = new Doing();
        doing.setUserId(question.getUserId());
        doing.setAction("发起提问");
        doing.setSourceId(question.getId());
        doing.setSourceType("question");
        doing.setContent(question.getTitle());
        doingMapper.insertSelective(doing);
        return result > 0;

    }

    /**
     * 查询未建立索引的问题
     *
     * @return 返回未建立索引的问题集合
     */
    @Override
    public List<Question> queryUnIndexQuestion() {
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andIndexedEqualTo(Byte.valueOf("0"));
        return questionMapper.selectByExampleWithBLOBs(questionExample);
    }

    /**
     * 根据问题id更新问题索引状态
     *
     * @param questionIds 问题id集合
     */
    @Override
    public void updateIndexed(List<Integer> questionIds) {
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andIdIn(questionIds);
        Question question = new Question();
        question.setIndexed(Byte.valueOf("1"));
        questionMapper.updateByExampleSelective(question, questionExample);
    }

    /**
     * 根据条件查询问题
     *
     * @param type       问题类型
     * @param categoryId 分类
     * @param pageNum    第几页
     * @param pageSize   每页大小
     * @return 返回满足条件的集合 和集合大小
     */
    @Override
    public Pair<List<QuestionVo>, Integer> queryByCondition(String type, Integer categoryId, Integer pageNum, Integer pageSize) {
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();

        Map<String, Object> conditionMap = new HashMap<>();
        if (!Integer.valueOf(0).equals(categoryId)) {
            conditionMap.put("categoryId", categoryId);
            criteria.andCategoryIdEqualTo(categoryId);
        }

        if (QuestionTypeEnum.NEWEST.getSlug().equals(type)) {
            PageHelper.startPage(pageNum, pageSize, "created_at desc");
        }else if (QuestionTypeEnum.HOTTEST.getSlug().equals(type)){
            PageHelper.startPage(pageNum, pageSize, "views desc");
            criteria.andViewsGreaterThan(0);
            conditionMap.put("views", 0);
        }else if (QuestionTypeEnum.REWARD.getSlug().equals(type)) {
            criteria.andPriceGreaterThan(Short.valueOf("0"));
            conditionMap.put("price", 0);
            PageHelper.startPage(pageNum, pageSize, "price desc");
        } else if (QuestionTypeEnum.UNANSWERED.getSlug().equals(type)) {
            criteria.andStatusEqualTo(Byte.valueOf("0"));
            conditionMap.put("status", 0);
            PageHelper.startPage(pageNum, pageSize);
        }

        List<Question> questionList = questionMapper.selectByExample(questionExample);
        List<QuestionVo> questionVoList = new ArrayList<>();
        questionList.iterator().forEachRemaining(question -> questionVoList.add(questionToQuestionVo(question)));

        Integer count = questionMapper.count(conditionMap);

        return Pair.of(questionVoList, count);
    }

    /**
     * 根据用户id查询问题
     *
     * @param userId 用户id
     * @return 返回问题集合
     */
    @Override
    public List<QuestionVo> queryByUserId(Integer userId) {

        QuestionExample questionExample  = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria();
        criteria.andUserIdEqualTo(userId);

        List<Question> questionList = questionMapper.selectByExampleWithBLOBs(questionExample);
        List<QuestionVo> questionVoList = new ArrayList<>();

        questionList.iterator().forEachRemaining(question -> {
            questionVoList.add(questionToQuestionVo(question));
        });
        return questionVoList;
    }

    /**
     * 根据回答id更新回答采纳状态
     *
     * @param answerId 回答id
     */
    @Override
    public Integer adoptAnswer(Integer answerId) {
        Answer answer = answerMapper.selectByPrimaryKey(answerId);

        Question question = questionMapper.selectByPrimaryKey(answer.getQuestionId());

        UserData userData = userDataMapper.selectByPrimaryKey(answer.getUserId());
        userData.setCoins(userData.getCoins() + question.getPrice());
        userDataMapper.updateByPrimaryKeySelective(userData);

        answer.setAdoptedAt(new Date());
        answerMapper.updateByPrimaryKeySelective(answer);

        return question.getId();
    }

    /**
     * 收藏问题
     *
     * @param questionId 问题id
     * @param userId     用户id
     */
    @Override
    public void collectionQuestion(Integer questionId, Integer userId) {
        Collections collections = new Collections();
        collections.setUserId(userId);
        collections.setSourceId(questionId);
        collections.setSourceType("question");

        Question question = questionMapper.selectByPrimaryKey(questionId);
        question.setCollections(question.getCollections() +1);
        questionMapper.updateByPrimaryKeySelective(question);

        collectionsMapper.insertSelective(collections);
    }

    /**
     * 关注问题
     *
     * @param questionId 问题id
     * @param userId     用户id
     */
    @Override
    public void followQuestion(Integer questionId, Integer userId) {
        Attention attention = new Attention();
        attention.setUserId(userId);
        attention.setSourceId(questionId);
        attention.setSourceType("question");

        Question question = questionMapper.selectByPrimaryKey(questionId);
        question.setFollowers(question.getFollowers() +1);
        questionMapper.updateByPrimaryKeySelective(question);

        attentionMapper.insertSelective(attention);
    }

    /**
     * 查询用户的收藏
     *
     * @param userId 用户id
     * @return 返回收藏集合
     */
    @Override
    public List<Collections> queryCollection(Integer userId, Integer questionId) {
        CollectionsExample collectionsExample = new CollectionsExample();
        CollectionsExample.Criteria criteria = collectionsExample.createCriteria();
        if (userId != null){
            criteria.andUserIdEqualTo(userId);
        }
        if (questionId != null){
            criteria.andSourceIdEqualTo(questionId);
        }
        return collectionsMapper.selectByExample(collectionsExample);
    }

    /**
     * 查询关注问题
     *
     * @param userId     用户id
     * @param questionId 问题id
     * @return 返回关注问题集合s
     */
    @Override
    public List<Attention> queryAttention(Integer userId, Integer questionId) {
        AttentionExample attentionExample = new AttentionExample();
        AttentionExample.Criteria criteria = attentionExample.createCriteria();
        if (userId != null){
            criteria.andUserIdEqualTo(userId);
        }
        if (questionId != null){
            criteria.andSourceIdEqualTo(questionId);
        }
        return attentionMapper.selectByExample(attentionExample);
    }

    /**
     * 将question转成questionVo
     *
     * @param question question对象
     * @return 返回questionVo对象
     */
    private QuestionVo questionToQuestionVo(Question question) {
        QuestionVo questionVo = new QuestionVo();
        BeanUtils.copyProperties(question, questionVo);
        if (question.getCreatedAt() != null) {
            questionVo.setCreateTime(DateUtil.dateToString(DateUtil.yyyy_MM_dd_HH_mm_ss, question.getCreatedAt()));
        }
        if (question.getUpdatedAt() != null) {
            questionVo.setUpdateTime(DateUtil.dateToString(DateUtil.yyyy_MM_dd_HH_mm_ss, question.getUpdatedAt()));
        }

        User user = userMapper.selectByPrimaryKey(question.getUserId());

        questionVo.setUser(user);

        return questionVo;
    }


}
