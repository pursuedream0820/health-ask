package com.hebeu.ask.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreditExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CreditExample() {
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

        public Criteria andActionIsNull() {
            addCriterion("action is null");
            return (Criteria) this;
        }

        public Criteria andActionIsNotNull() {
            addCriterion("action is not null");
            return (Criteria) this;
        }

        public Criteria andActionEqualTo(String value) {
            addCriterion("action =", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotEqualTo(String value) {
            addCriterion("action <>", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThan(String value) {
            addCriterion("action >", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThanOrEqualTo(String value) {
            addCriterion("action >=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThan(String value) {
            addCriterion("action <", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThanOrEqualTo(String value) {
            addCriterion("action <=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLike(String value) {
            addCriterion("action like", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotLike(String value) {
            addCriterion("action not like", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionIn(List<String> values) {
            addCriterion("action in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotIn(List<String> values) {
            addCriterion("action not in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionBetween(String value1, String value2) {
            addCriterion("action between", value1, value2, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotBetween(String value1, String value2) {
            addCriterion("action not between", value1, value2, "action");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNull() {
            addCriterion("source_id is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("source_id is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(Integer value) {
            addCriterion("source_id =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(Integer value) {
            addCriterion("source_id <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(Integer value) {
            addCriterion("source_id >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("source_id >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(Integer value) {
            addCriterion("source_id <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("source_id <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<Integer> values) {
            addCriterion("source_id in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<Integer> values) {
            addCriterion("source_id not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(Integer value1, Integer value2) {
            addCriterion("source_id between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("source_id not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceSubjectIsNull() {
            addCriterion("source_subject is null");
            return (Criteria) this;
        }

        public Criteria andSourceSubjectIsNotNull() {
            addCriterion("source_subject is not null");
            return (Criteria) this;
        }

        public Criteria andSourceSubjectEqualTo(String value) {
            addCriterion("source_subject =", value, "sourceSubject");
            return (Criteria) this;
        }

        public Criteria andSourceSubjectNotEqualTo(String value) {
            addCriterion("source_subject <>", value, "sourceSubject");
            return (Criteria) this;
        }

        public Criteria andSourceSubjectGreaterThan(String value) {
            addCriterion("source_subject >", value, "sourceSubject");
            return (Criteria) this;
        }

        public Criteria andSourceSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("source_subject >=", value, "sourceSubject");
            return (Criteria) this;
        }

        public Criteria andSourceSubjectLessThan(String value) {
            addCriterion("source_subject <", value, "sourceSubject");
            return (Criteria) this;
        }

        public Criteria andSourceSubjectLessThanOrEqualTo(String value) {
            addCriterion("source_subject <=", value, "sourceSubject");
            return (Criteria) this;
        }

        public Criteria andSourceSubjectLike(String value) {
            addCriterion("source_subject like", value, "sourceSubject");
            return (Criteria) this;
        }

        public Criteria andSourceSubjectNotLike(String value) {
            addCriterion("source_subject not like", value, "sourceSubject");
            return (Criteria) this;
        }

        public Criteria andSourceSubjectIn(List<String> values) {
            addCriterion("source_subject in", values, "sourceSubject");
            return (Criteria) this;
        }

        public Criteria andSourceSubjectNotIn(List<String> values) {
            addCriterion("source_subject not in", values, "sourceSubject");
            return (Criteria) this;
        }

        public Criteria andSourceSubjectBetween(String value1, String value2) {
            addCriterion("source_subject between", value1, value2, "sourceSubject");
            return (Criteria) this;
        }

        public Criteria andSourceSubjectNotBetween(String value1, String value2) {
            addCriterion("source_subject not between", value1, value2, "sourceSubject");
            return (Criteria) this;
        }

        public Criteria andCoinsIsNull() {
            addCriterion("coins is null");
            return (Criteria) this;
        }

        public Criteria andCoinsIsNotNull() {
            addCriterion("coins is not null");
            return (Criteria) this;
        }

        public Criteria andCoinsEqualTo(Integer value) {
            addCriterion("coins =", value, "coins");
            return (Criteria) this;
        }

        public Criteria andCoinsNotEqualTo(Integer value) {
            addCriterion("coins <>", value, "coins");
            return (Criteria) this;
        }

        public Criteria andCoinsGreaterThan(Integer value) {
            addCriterion("coins >", value, "coins");
            return (Criteria) this;
        }

        public Criteria andCoinsGreaterThanOrEqualTo(Integer value) {
            addCriterion("coins >=", value, "coins");
            return (Criteria) this;
        }

        public Criteria andCoinsLessThan(Integer value) {
            addCriterion("coins <", value, "coins");
            return (Criteria) this;
        }

        public Criteria andCoinsLessThanOrEqualTo(Integer value) {
            addCriterion("coins <=", value, "coins");
            return (Criteria) this;
        }

        public Criteria andCoinsIn(List<Integer> values) {
            addCriterion("coins in", values, "coins");
            return (Criteria) this;
        }

        public Criteria andCoinsNotIn(List<Integer> values) {
            addCriterion("coins not in", values, "coins");
            return (Criteria) this;
        }

        public Criteria andCoinsBetween(Integer value1, Integer value2) {
            addCriterion("coins between", value1, value2, "coins");
            return (Criteria) this;
        }

        public Criteria andCoinsNotBetween(Integer value1, Integer value2) {
            addCriterion("coins not between", value1, value2, "coins");
            return (Criteria) this;
        }

        public Criteria andCreditsIsNull() {
            addCriterion("credits is null");
            return (Criteria) this;
        }

        public Criteria andCreditsIsNotNull() {
            addCriterion("credits is not null");
            return (Criteria) this;
        }

        public Criteria andCreditsEqualTo(Integer value) {
            addCriterion("credits =", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotEqualTo(Integer value) {
            addCriterion("credits <>", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsGreaterThan(Integer value) {
            addCriterion("credits >", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsGreaterThanOrEqualTo(Integer value) {
            addCriterion("credits >=", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsLessThan(Integer value) {
            addCriterion("credits <", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsLessThanOrEqualTo(Integer value) {
            addCriterion("credits <=", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsIn(List<Integer> values) {
            addCriterion("credits in", values, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotIn(List<Integer> values) {
            addCriterion("credits not in", values, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsBetween(Integer value1, Integer value2) {
            addCriterion("credits between", value1, value2, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotBetween(Integer value1, Integer value2) {
            addCriterion("credits not between", value1, value2, "credits");
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