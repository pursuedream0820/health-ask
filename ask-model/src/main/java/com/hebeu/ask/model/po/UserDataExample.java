package com.hebeu.ask.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserDataExample() {
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

        public Criteria andRegisteredAtIsNull() {
            addCriterion("registered_at is null");
            return (Criteria) this;
        }

        public Criteria andRegisteredAtIsNotNull() {
            addCriterion("registered_at is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteredAtEqualTo(Date value) {
            addCriterion("registered_at =", value, "registeredAt");
            return (Criteria) this;
        }

        public Criteria andRegisteredAtNotEqualTo(Date value) {
            addCriterion("registered_at <>", value, "registeredAt");
            return (Criteria) this;
        }

        public Criteria andRegisteredAtGreaterThan(Date value) {
            addCriterion("registered_at >", value, "registeredAt");
            return (Criteria) this;
        }

        public Criteria andRegisteredAtGreaterThanOrEqualTo(Date value) {
            addCriterion("registered_at >=", value, "registeredAt");
            return (Criteria) this;
        }

        public Criteria andRegisteredAtLessThan(Date value) {
            addCriterion("registered_at <", value, "registeredAt");
            return (Criteria) this;
        }

        public Criteria andRegisteredAtLessThanOrEqualTo(Date value) {
            addCriterion("registered_at <=", value, "registeredAt");
            return (Criteria) this;
        }

        public Criteria andRegisteredAtIn(List<Date> values) {
            addCriterion("registered_at in", values, "registeredAt");
            return (Criteria) this;
        }

        public Criteria andRegisteredAtNotIn(List<Date> values) {
            addCriterion("registered_at not in", values, "registeredAt");
            return (Criteria) this;
        }

        public Criteria andRegisteredAtBetween(Date value1, Date value2) {
            addCriterion("registered_at between", value1, value2, "registeredAt");
            return (Criteria) this;
        }

        public Criteria andRegisteredAtNotBetween(Date value1, Date value2) {
            addCriterion("registered_at not between", value1, value2, "registeredAt");
            return (Criteria) this;
        }

        public Criteria andLastVisitIsNull() {
            addCriterion("last_visit is null");
            return (Criteria) this;
        }

        public Criteria andLastVisitIsNotNull() {
            addCriterion("last_visit is not null");
            return (Criteria) this;
        }

        public Criteria andLastVisitEqualTo(Date value) {
            addCriterion("last_visit =", value, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitNotEqualTo(Date value) {
            addCriterion("last_visit <>", value, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitGreaterThan(Date value) {
            addCriterion("last_visit >", value, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitGreaterThanOrEqualTo(Date value) {
            addCriterion("last_visit >=", value, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitLessThan(Date value) {
            addCriterion("last_visit <", value, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitLessThanOrEqualTo(Date value) {
            addCriterion("last_visit <=", value, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitIn(List<Date> values) {
            addCriterion("last_visit in", values, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitNotIn(List<Date> values) {
            addCriterion("last_visit not in", values, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitBetween(Date value1, Date value2) {
            addCriterion("last_visit between", value1, value2, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitNotBetween(Date value1, Date value2) {
            addCriterion("last_visit not between", value1, value2, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNull() {
            addCriterion("last_login_ip is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNotNull() {
            addCriterion("last_login_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpEqualTo(String value) {
            addCriterion("last_login_ip =", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotEqualTo(String value) {
            addCriterion("last_login_ip <>", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThan(String value) {
            addCriterion("last_login_ip >", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("last_login_ip >=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThan(String value) {
            addCriterion("last_login_ip <", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThanOrEqualTo(String value) {
            addCriterion("last_login_ip <=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLike(String value) {
            addCriterion("last_login_ip like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotLike(String value) {
            addCriterion("last_login_ip not like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIn(List<String> values) {
            addCriterion("last_login_ip in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotIn(List<String> values) {
            addCriterion("last_login_ip not in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpBetween(String value1, String value2) {
            addCriterion("last_login_ip between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotBetween(String value1, String value2) {
            addCriterion("last_login_ip not between", value1, value2, "lastLoginIp");
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

        public Criteria andFollowersIsNull() {
            addCriterion("followers is null");
            return (Criteria) this;
        }

        public Criteria andFollowersIsNotNull() {
            addCriterion("followers is not null");
            return (Criteria) this;
        }

        public Criteria andFollowersEqualTo(Integer value) {
            addCriterion("followers =", value, "followers");
            return (Criteria) this;
        }

        public Criteria andFollowersNotEqualTo(Integer value) {
            addCriterion("followers <>", value, "followers");
            return (Criteria) this;
        }

        public Criteria andFollowersGreaterThan(Integer value) {
            addCriterion("followers >", value, "followers");
            return (Criteria) this;
        }

        public Criteria andFollowersGreaterThanOrEqualTo(Integer value) {
            addCriterion("followers >=", value, "followers");
            return (Criteria) this;
        }

        public Criteria andFollowersLessThan(Integer value) {
            addCriterion("followers <", value, "followers");
            return (Criteria) this;
        }

        public Criteria andFollowersLessThanOrEqualTo(Integer value) {
            addCriterion("followers <=", value, "followers");
            return (Criteria) this;
        }

        public Criteria andFollowersIn(List<Integer> values) {
            addCriterion("followers in", values, "followers");
            return (Criteria) this;
        }

        public Criteria andFollowersNotIn(List<Integer> values) {
            addCriterion("followers not in", values, "followers");
            return (Criteria) this;
        }

        public Criteria andFollowersBetween(Integer value1, Integer value2) {
            addCriterion("followers between", value1, value2, "followers");
            return (Criteria) this;
        }

        public Criteria andFollowersNotBetween(Integer value1, Integer value2) {
            addCriterion("followers not between", value1, value2, "followers");
            return (Criteria) this;
        }

        public Criteria andViewsIsNull() {
            addCriterion("views is null");
            return (Criteria) this;
        }

        public Criteria andViewsIsNotNull() {
            addCriterion("views is not null");
            return (Criteria) this;
        }

        public Criteria andViewsEqualTo(Integer value) {
            addCriterion("views =", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsNotEqualTo(Integer value) {
            addCriterion("views <>", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsGreaterThan(Integer value) {
            addCriterion("views >", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsGreaterThanOrEqualTo(Integer value) {
            addCriterion("views >=", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsLessThan(Integer value) {
            addCriterion("views <", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsLessThanOrEqualTo(Integer value) {
            addCriterion("views <=", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsIn(List<Integer> values) {
            addCriterion("views in", values, "views");
            return (Criteria) this;
        }

        public Criteria andViewsNotIn(List<Integer> values) {
            addCriterion("views not in", values, "views");
            return (Criteria) this;
        }

        public Criteria andViewsBetween(Integer value1, Integer value2) {
            addCriterion("views between", value1, value2, "views");
            return (Criteria) this;
        }

        public Criteria andViewsNotBetween(Integer value1, Integer value2) {
            addCriterion("views not between", value1, value2, "views");
            return (Criteria) this;
        }

        public Criteria andEmailStatusIsNull() {
            addCriterion("email_status is null");
            return (Criteria) this;
        }

        public Criteria andEmailStatusIsNotNull() {
            addCriterion("email_status is not null");
            return (Criteria) this;
        }

        public Criteria andEmailStatusEqualTo(Byte value) {
            addCriterion("email_status =", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusNotEqualTo(Byte value) {
            addCriterion("email_status <>", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusGreaterThan(Byte value) {
            addCriterion("email_status >", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("email_status >=", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusLessThan(Byte value) {
            addCriterion("email_status <", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusLessThanOrEqualTo(Byte value) {
            addCriterion("email_status <=", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusIn(List<Byte> values) {
            addCriterion("email_status in", values, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusNotIn(List<Byte> values) {
            addCriterion("email_status not in", values, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusBetween(Byte value1, Byte value2) {
            addCriterion("email_status between", value1, value2, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("email_status not between", value1, value2, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusIsNull() {
            addCriterion("mobile_status is null");
            return (Criteria) this;
        }

        public Criteria andMobileStatusIsNotNull() {
            addCriterion("mobile_status is not null");
            return (Criteria) this;
        }

        public Criteria andMobileStatusEqualTo(Byte value) {
            addCriterion("mobile_status =", value, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusNotEqualTo(Byte value) {
            addCriterion("mobile_status <>", value, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusGreaterThan(Byte value) {
            addCriterion("mobile_status >", value, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("mobile_status >=", value, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusLessThan(Byte value) {
            addCriterion("mobile_status <", value, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusLessThanOrEqualTo(Byte value) {
            addCriterion("mobile_status <=", value, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusIn(List<Byte> values) {
            addCriterion("mobile_status in", values, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusNotIn(List<Byte> values) {
            addCriterion("mobile_status not in", values, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusBetween(Byte value1, Byte value2) {
            addCriterion("mobile_status between", value1, value2, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("mobile_status not between", value1, value2, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusIsNull() {
            addCriterion("authentication_status is null");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusIsNotNull() {
            addCriterion("authentication_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusEqualTo(Byte value) {
            addCriterion("authentication_status =", value, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusNotEqualTo(Byte value) {
            addCriterion("authentication_status <>", value, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusGreaterThan(Byte value) {
            addCriterion("authentication_status >", value, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("authentication_status >=", value, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusLessThan(Byte value) {
            addCriterion("authentication_status <", value, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusLessThanOrEqualTo(Byte value) {
            addCriterion("authentication_status <=", value, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusIn(List<Byte> values) {
            addCriterion("authentication_status in", values, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusNotIn(List<Byte> values) {
            addCriterion("authentication_status not in", values, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusBetween(Byte value1, Byte value2) {
            addCriterion("authentication_status between", value1, value2, "authenticationStatus");
            return (Criteria) this;
        }

        public Criteria andAuthenticationStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("authentication_status not between", value1, value2, "authenticationStatus");
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