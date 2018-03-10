package com.hebeu.ask.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTagExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserTagExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTagIdIsNull() {
            addCriterion("tag_id is null");
            return (Criteria) this;
        }

        public Criteria andTagIdIsNotNull() {
            addCriterion("tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andTagIdEqualTo(Integer value) {
            addCriterion("tag_id =", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotEqualTo(Integer value) {
            addCriterion("tag_id <>", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdGreaterThan(Integer value) {
            addCriterion("tag_id >", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tag_id >=", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLessThan(Integer value) {
            addCriterion("tag_id <", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLessThanOrEqualTo(Integer value) {
            addCriterion("tag_id <=", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdIn(List<Integer> values) {
            addCriterion("tag_id in", values, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotIn(List<Integer> values) {
            addCriterion("tag_id not in", values, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdBetween(Integer value1, Integer value2) {
            addCriterion("tag_id between", value1, value2, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tag_id not between", value1, value2, "tagId");
            return (Criteria) this;
        }

        public Criteria andQuestionsIsNull() {
            addCriterion("questions is null");
            return (Criteria) this;
        }

        public Criteria andQuestionsIsNotNull() {
            addCriterion("questions is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionsEqualTo(Integer value) {
            addCriterion("questions =", value, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsNotEqualTo(Integer value) {
            addCriterion("questions <>", value, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsGreaterThan(Integer value) {
            addCriterion("questions >", value, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsGreaterThanOrEqualTo(Integer value) {
            addCriterion("questions >=", value, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsLessThan(Integer value) {
            addCriterion("questions <", value, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsLessThanOrEqualTo(Integer value) {
            addCriterion("questions <=", value, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsIn(List<Integer> values) {
            addCriterion("questions in", values, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsNotIn(List<Integer> values) {
            addCriterion("questions not in", values, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsBetween(Integer value1, Integer value2) {
            addCriterion("questions between", value1, value2, "questions");
            return (Criteria) this;
        }

        public Criteria andQuestionsNotBetween(Integer value1, Integer value2) {
            addCriterion("questions not between", value1, value2, "questions");
            return (Criteria) this;
        }

        public Criteria andArticlesIsNull() {
            addCriterion("articles is null");
            return (Criteria) this;
        }

        public Criteria andArticlesIsNotNull() {
            addCriterion("articles is not null");
            return (Criteria) this;
        }

        public Criteria andArticlesEqualTo(Integer value) {
            addCriterion("articles =", value, "articles");
            return (Criteria) this;
        }

        public Criteria andArticlesNotEqualTo(Integer value) {
            addCriterion("articles <>", value, "articles");
            return (Criteria) this;
        }

        public Criteria andArticlesGreaterThan(Integer value) {
            addCriterion("articles >", value, "articles");
            return (Criteria) this;
        }

        public Criteria andArticlesGreaterThanOrEqualTo(Integer value) {
            addCriterion("articles >=", value, "articles");
            return (Criteria) this;
        }

        public Criteria andArticlesLessThan(Integer value) {
            addCriterion("articles <", value, "articles");
            return (Criteria) this;
        }

        public Criteria andArticlesLessThanOrEqualTo(Integer value) {
            addCriterion("articles <=", value, "articles");
            return (Criteria) this;
        }

        public Criteria andArticlesIn(List<Integer> values) {
            addCriterion("articles in", values, "articles");
            return (Criteria) this;
        }

        public Criteria andArticlesNotIn(List<Integer> values) {
            addCriterion("articles not in", values, "articles");
            return (Criteria) this;
        }

        public Criteria andArticlesBetween(Integer value1, Integer value2) {
            addCriterion("articles between", value1, value2, "articles");
            return (Criteria) this;
        }

        public Criteria andArticlesNotBetween(Integer value1, Integer value2) {
            addCriterion("articles not between", value1, value2, "articles");
            return (Criteria) this;
        }

        public Criteria andAnswersIsNull() {
            addCriterion("answers is null");
            return (Criteria) this;
        }

        public Criteria andAnswersIsNotNull() {
            addCriterion("answers is not null");
            return (Criteria) this;
        }

        public Criteria andAnswersEqualTo(Integer value) {
            addCriterion("answers =", value, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersNotEqualTo(Integer value) {
            addCriterion("answers <>", value, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersGreaterThan(Integer value) {
            addCriterion("answers >", value, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersGreaterThanOrEqualTo(Integer value) {
            addCriterion("answers >=", value, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersLessThan(Integer value) {
            addCriterion("answers <", value, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersLessThanOrEqualTo(Integer value) {
            addCriterion("answers <=", value, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersIn(List<Integer> values) {
            addCriterion("answers in", values, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersNotIn(List<Integer> values) {
            addCriterion("answers not in", values, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersBetween(Integer value1, Integer value2) {
            addCriterion("answers between", value1, value2, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersNotBetween(Integer value1, Integer value2) {
            addCriterion("answers not between", value1, value2, "answers");
            return (Criteria) this;
        }

        public Criteria andSupportsIsNull() {
            addCriterion("supports is null");
            return (Criteria) this;
        }

        public Criteria andSupportsIsNotNull() {
            addCriterion("supports is not null");
            return (Criteria) this;
        }

        public Criteria andSupportsEqualTo(Integer value) {
            addCriterion("supports =", value, "supports");
            return (Criteria) this;
        }

        public Criteria andSupportsNotEqualTo(Integer value) {
            addCriterion("supports <>", value, "supports");
            return (Criteria) this;
        }

        public Criteria andSupportsGreaterThan(Integer value) {
            addCriterion("supports >", value, "supports");
            return (Criteria) this;
        }

        public Criteria andSupportsGreaterThanOrEqualTo(Integer value) {
            addCriterion("supports >=", value, "supports");
            return (Criteria) this;
        }

        public Criteria andSupportsLessThan(Integer value) {
            addCriterion("supports <", value, "supports");
            return (Criteria) this;
        }

        public Criteria andSupportsLessThanOrEqualTo(Integer value) {
            addCriterion("supports <=", value, "supports");
            return (Criteria) this;
        }

        public Criteria andSupportsIn(List<Integer> values) {
            addCriterion("supports in", values, "supports");
            return (Criteria) this;
        }

        public Criteria andSupportsNotIn(List<Integer> values) {
            addCriterion("supports not in", values, "supports");
            return (Criteria) this;
        }

        public Criteria andSupportsBetween(Integer value1, Integer value2) {
            addCriterion("supports between", value1, value2, "supports");
            return (Criteria) this;
        }

        public Criteria andSupportsNotBetween(Integer value1, Integer value2) {
            addCriterion("supports not between", value1, value2, "supports");
            return (Criteria) this;
        }

        public Criteria andAdoptionsIsNull() {
            addCriterion("adoptions is null");
            return (Criteria) this;
        }

        public Criteria andAdoptionsIsNotNull() {
            addCriterion("adoptions is not null");
            return (Criteria) this;
        }

        public Criteria andAdoptionsEqualTo(Integer value) {
            addCriterion("adoptions =", value, "adoptions");
            return (Criteria) this;
        }

        public Criteria andAdoptionsNotEqualTo(Integer value) {
            addCriterion("adoptions <>", value, "adoptions");
            return (Criteria) this;
        }

        public Criteria andAdoptionsGreaterThan(Integer value) {
            addCriterion("adoptions >", value, "adoptions");
            return (Criteria) this;
        }

        public Criteria andAdoptionsGreaterThanOrEqualTo(Integer value) {
            addCriterion("adoptions >=", value, "adoptions");
            return (Criteria) this;
        }

        public Criteria andAdoptionsLessThan(Integer value) {
            addCriterion("adoptions <", value, "adoptions");
            return (Criteria) this;
        }

        public Criteria andAdoptionsLessThanOrEqualTo(Integer value) {
            addCriterion("adoptions <=", value, "adoptions");
            return (Criteria) this;
        }

        public Criteria andAdoptionsIn(List<Integer> values) {
            addCriterion("adoptions in", values, "adoptions");
            return (Criteria) this;
        }

        public Criteria andAdoptionsNotIn(List<Integer> values) {
            addCriterion("adoptions not in", values, "adoptions");
            return (Criteria) this;
        }

        public Criteria andAdoptionsBetween(Integer value1, Integer value2) {
            addCriterion("adoptions between", value1, value2, "adoptions");
            return (Criteria) this;
        }

        public Criteria andAdoptionsNotBetween(Integer value1, Integer value2) {
            addCriterion("adoptions not between", value1, value2, "adoptions");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}