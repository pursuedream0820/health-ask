package com.hebeu.ask.model.po;

import java.util.ArrayList;
import java.util.List;

public class JobExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JobExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andQueueIsNull() {
            addCriterion("queue is null");
            return (Criteria) this;
        }

        public Criteria andQueueIsNotNull() {
            addCriterion("queue is not null");
            return (Criteria) this;
        }

        public Criteria andQueueEqualTo(String value) {
            addCriterion("queue =", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueNotEqualTo(String value) {
            addCriterion("queue <>", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueGreaterThan(String value) {
            addCriterion("queue >", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueGreaterThanOrEqualTo(String value) {
            addCriterion("queue >=", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueLessThan(String value) {
            addCriterion("queue <", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueLessThanOrEqualTo(String value) {
            addCriterion("queue <=", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueLike(String value) {
            addCriterion("queue like", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueNotLike(String value) {
            addCriterion("queue not like", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueIn(List<String> values) {
            addCriterion("queue in", values, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueNotIn(List<String> values) {
            addCriterion("queue not in", values, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueBetween(String value1, String value2) {
            addCriterion("queue between", value1, value2, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueNotBetween(String value1, String value2) {
            addCriterion("queue not between", value1, value2, "queue");
            return (Criteria) this;
        }

        public Criteria andAttemptsIsNull() {
            addCriterion("attempts is null");
            return (Criteria) this;
        }

        public Criteria andAttemptsIsNotNull() {
            addCriterion("attempts is not null");
            return (Criteria) this;
        }

        public Criteria andAttemptsEqualTo(Byte value) {
            addCriterion("attempts =", value, "attempts");
            return (Criteria) this;
        }

        public Criteria andAttemptsNotEqualTo(Byte value) {
            addCriterion("attempts <>", value, "attempts");
            return (Criteria) this;
        }

        public Criteria andAttemptsGreaterThan(Byte value) {
            addCriterion("attempts >", value, "attempts");
            return (Criteria) this;
        }

        public Criteria andAttemptsGreaterThanOrEqualTo(Byte value) {
            addCriterion("attempts >=", value, "attempts");
            return (Criteria) this;
        }

        public Criteria andAttemptsLessThan(Byte value) {
            addCriterion("attempts <", value, "attempts");
            return (Criteria) this;
        }

        public Criteria andAttemptsLessThanOrEqualTo(Byte value) {
            addCriterion("attempts <=", value, "attempts");
            return (Criteria) this;
        }

        public Criteria andAttemptsIn(List<Byte> values) {
            addCriterion("attempts in", values, "attempts");
            return (Criteria) this;
        }

        public Criteria andAttemptsNotIn(List<Byte> values) {
            addCriterion("attempts not in", values, "attempts");
            return (Criteria) this;
        }

        public Criteria andAttemptsBetween(Byte value1, Byte value2) {
            addCriterion("attempts between", value1, value2, "attempts");
            return (Criteria) this;
        }

        public Criteria andAttemptsNotBetween(Byte value1, Byte value2) {
            addCriterion("attempts not between", value1, value2, "attempts");
            return (Criteria) this;
        }

        public Criteria andReservedIsNull() {
            addCriterion("reserved is null");
            return (Criteria) this;
        }

        public Criteria andReservedIsNotNull() {
            addCriterion("reserved is not null");
            return (Criteria) this;
        }

        public Criteria andReservedEqualTo(Byte value) {
            addCriterion("reserved =", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotEqualTo(Byte value) {
            addCriterion("reserved <>", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedGreaterThan(Byte value) {
            addCriterion("reserved >", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedGreaterThanOrEqualTo(Byte value) {
            addCriterion("reserved >=", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedLessThan(Byte value) {
            addCriterion("reserved <", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedLessThanOrEqualTo(Byte value) {
            addCriterion("reserved <=", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedIn(List<Byte> values) {
            addCriterion("reserved in", values, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotIn(List<Byte> values) {
            addCriterion("reserved not in", values, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedBetween(Byte value1, Byte value2) {
            addCriterion("reserved between", value1, value2, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotBetween(Byte value1, Byte value2) {
            addCriterion("reserved not between", value1, value2, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedAtIsNull() {
            addCriterion("reserved_at is null");
            return (Criteria) this;
        }

        public Criteria andReservedAtIsNotNull() {
            addCriterion("reserved_at is not null");
            return (Criteria) this;
        }

        public Criteria andReservedAtEqualTo(Integer value) {
            addCriterion("reserved_at =", value, "reservedAt");
            return (Criteria) this;
        }

        public Criteria andReservedAtNotEqualTo(Integer value) {
            addCriterion("reserved_at <>", value, "reservedAt");
            return (Criteria) this;
        }

        public Criteria andReservedAtGreaterThan(Integer value) {
            addCriterion("reserved_at >", value, "reservedAt");
            return (Criteria) this;
        }

        public Criteria andReservedAtGreaterThanOrEqualTo(Integer value) {
            addCriterion("reserved_at >=", value, "reservedAt");
            return (Criteria) this;
        }

        public Criteria andReservedAtLessThan(Integer value) {
            addCriterion("reserved_at <", value, "reservedAt");
            return (Criteria) this;
        }

        public Criteria andReservedAtLessThanOrEqualTo(Integer value) {
            addCriterion("reserved_at <=", value, "reservedAt");
            return (Criteria) this;
        }

        public Criteria andReservedAtIn(List<Integer> values) {
            addCriterion("reserved_at in", values, "reservedAt");
            return (Criteria) this;
        }

        public Criteria andReservedAtNotIn(List<Integer> values) {
            addCriterion("reserved_at not in", values, "reservedAt");
            return (Criteria) this;
        }

        public Criteria andReservedAtBetween(Integer value1, Integer value2) {
            addCriterion("reserved_at between", value1, value2, "reservedAt");
            return (Criteria) this;
        }

        public Criteria andReservedAtNotBetween(Integer value1, Integer value2) {
            addCriterion("reserved_at not between", value1, value2, "reservedAt");
            return (Criteria) this;
        }

        public Criteria andAvailableAtIsNull() {
            addCriterion("available_at is null");
            return (Criteria) this;
        }

        public Criteria andAvailableAtIsNotNull() {
            addCriterion("available_at is not null");
            return (Criteria) this;
        }

        public Criteria andAvailableAtEqualTo(Integer value) {
            addCriterion("available_at =", value, "availableAt");
            return (Criteria) this;
        }

        public Criteria andAvailableAtNotEqualTo(Integer value) {
            addCriterion("available_at <>", value, "availableAt");
            return (Criteria) this;
        }

        public Criteria andAvailableAtGreaterThan(Integer value) {
            addCriterion("available_at >", value, "availableAt");
            return (Criteria) this;
        }

        public Criteria andAvailableAtGreaterThanOrEqualTo(Integer value) {
            addCriterion("available_at >=", value, "availableAt");
            return (Criteria) this;
        }

        public Criteria andAvailableAtLessThan(Integer value) {
            addCriterion("available_at <", value, "availableAt");
            return (Criteria) this;
        }

        public Criteria andAvailableAtLessThanOrEqualTo(Integer value) {
            addCriterion("available_at <=", value, "availableAt");
            return (Criteria) this;
        }

        public Criteria andAvailableAtIn(List<Integer> values) {
            addCriterion("available_at in", values, "availableAt");
            return (Criteria) this;
        }

        public Criteria andAvailableAtNotIn(List<Integer> values) {
            addCriterion("available_at not in", values, "availableAt");
            return (Criteria) this;
        }

        public Criteria andAvailableAtBetween(Integer value1, Integer value2) {
            addCriterion("available_at between", value1, value2, "availableAt");
            return (Criteria) this;
        }

        public Criteria andAvailableAtNotBetween(Integer value1, Integer value2) {
            addCriterion("available_at not between", value1, value2, "availableAt");
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

        public Criteria andCreatedAtEqualTo(Integer value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Integer value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Integer value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Integer value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Integer value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Integer value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Integer> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Integer> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Integer value1, Integer value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Integer value1, Integer value2) {
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