package com.zhdtedu.riverchiefs.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BasinInfoExample {
    //排序
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public BasinInfoExample() {
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
            addCriterion("ID_ is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID_ =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID_ <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID_ >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_ >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID_ <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID_ <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID_ in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID_ not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID_ between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID_ not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE_ is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE_ is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(Long value) {
            addCriterion("CODE_ =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(Long value) {
            addCriterion("CODE_ <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(Long value) {
            addCriterion("CODE_ >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("CODE_ >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(Long value) {
            addCriterion("CODE_ <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(Long value) {
            addCriterion("CODE_ <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<Long> values) {
            addCriterion("CODE_ in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<Long> values) {
            addCriterion("CODE_ not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(Long value1, Long value2) {
            addCriterion("CODE_ between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(Long value1, Long value2) {
            addCriterion("CODE_ not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("PARENT_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("PARENT_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("PARENT_ID_ =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("PARENT_ID_ <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("PARENT_ID_ >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PARENT_ID_ >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("PARENT_ID_ <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("PARENT_ID_ <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("PARENT_ID_ in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("PARENT_ID_ not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("PARENT_ID_ between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("PARENT_ID_ not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE_ is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE_ is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("TYPE_ =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("TYPE_ <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("TYPE_ >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TYPE_ >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("TYPE_ <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("TYPE_ <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("TYPE_ in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("TYPE_ not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("TYPE_ between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("TYPE_ not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME_ is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME_ is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME_ =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME_ <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME_ >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME_ >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME_ <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME_ <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME_ like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME_ not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME_ in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME_ not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME_ between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME_ not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andFirstManagerIsNull() {
            addCriterion("FIRST_MANAGER_ is null");
            return (Criteria) this;
        }

        public Criteria andFirstManagerIsNotNull() {
            addCriterion("FIRST_MANAGER_ is not null");
            return (Criteria) this;
        }

        public Criteria andFirstManagerEqualTo(String value) {
            addCriterion("FIRST_MANAGER_ =", value, "firstManager");
            return (Criteria) this;
        }

        public Criteria andFirstManagerNotEqualTo(String value) {
            addCriterion("FIRST_MANAGER_ <>", value, "firstManager");
            return (Criteria) this;
        }

        public Criteria andFirstManagerGreaterThan(String value) {
            addCriterion("FIRST_MANAGER_ >", value, "firstManager");
            return (Criteria) this;
        }

        public Criteria andFirstManagerGreaterThanOrEqualTo(String value) {
            addCriterion("FIRST_MANAGER_ >=", value, "firstManager");
            return (Criteria) this;
        }

        public Criteria andFirstManagerLessThan(String value) {
            addCriterion("FIRST_MANAGER_ <", value, "firstManager");
            return (Criteria) this;
        }

        public Criteria andFirstManagerLessThanOrEqualTo(String value) {
            addCriterion("FIRST_MANAGER_ <=", value, "firstManager");
            return (Criteria) this;
        }

        public Criteria andFirstManagerLike(String value) {
            addCriterion("FIRST_MANAGER_ like", value, "firstManager");
            return (Criteria) this;
        }

        public Criteria andFirstManagerNotLike(String value) {
            addCriterion("FIRST_MANAGER_ not like", value, "firstManager");
            return (Criteria) this;
        }

        public Criteria andFirstManagerIn(List<String> values) {
            addCriterion("FIRST_MANAGER_ in", values, "firstManager");
            return (Criteria) this;
        }

        public Criteria andFirstManagerNotIn(List<String> values) {
            addCriterion("FIRST_MANAGER_ not in", values, "firstManager");
            return (Criteria) this;
        }

        public Criteria andFirstManagerBetween(String value1, String value2) {
            addCriterion("FIRST_MANAGER_ between", value1, value2, "firstManager");
            return (Criteria) this;
        }

        public Criteria andFirstManagerNotBetween(String value1, String value2) {
            addCriterion("FIRST_MANAGER_ not between", value1, value2, "firstManager");
            return (Criteria) this;
        }

        public Criteria andFirstPostIsNull() {
            addCriterion("FIRST_POST_ is null");
            return (Criteria) this;
        }

        public Criteria andFirstPostIsNotNull() {
            addCriterion("FIRST_POST_ is not null");
            return (Criteria) this;
        }

        public Criteria andFirstPostEqualTo(String value) {
            addCriterion("FIRST_POST_ =", value, "firstPost");
            return (Criteria) this;
        }

        public Criteria andFirstPostNotEqualTo(String value) {
            addCriterion("FIRST_POST_ <>", value, "firstPost");
            return (Criteria) this;
        }

        public Criteria andFirstPostGreaterThan(String value) {
            addCriterion("FIRST_POST_ >", value, "firstPost");
            return (Criteria) this;
        }

        public Criteria andFirstPostGreaterThanOrEqualTo(String value) {
            addCriterion("FIRST_POST_ >=", value, "firstPost");
            return (Criteria) this;
        }

        public Criteria andFirstPostLessThan(String value) {
            addCriterion("FIRST_POST_ <", value, "firstPost");
            return (Criteria) this;
        }

        public Criteria andFirstPostLessThanOrEqualTo(String value) {
            addCriterion("FIRST_POST_ <=", value, "firstPost");
            return (Criteria) this;
        }

        public Criteria andFirstPostLike(String value) {
            addCriterion("FIRST_POST_ like", value, "firstPost");
            return (Criteria) this;
        }

        public Criteria andFirstPostNotLike(String value) {
            addCriterion("FIRST_POST_ not like", value, "firstPost");
            return (Criteria) this;
        }

        public Criteria andFirstPostIn(List<String> values) {
            addCriterion("FIRST_POST_ in", values, "firstPost");
            return (Criteria) this;
        }

        public Criteria andFirstPostNotIn(List<String> values) {
            addCriterion("FIRST_POST_ not in", values, "firstPost");
            return (Criteria) this;
        }

        public Criteria andFirstPostBetween(String value1, String value2) {
            addCriterion("FIRST_POST_ between", value1, value2, "firstPost");
            return (Criteria) this;
        }

        public Criteria andFirstPostNotBetween(String value1, String value2) {
            addCriterion("FIRST_POST_ not between", value1, value2, "firstPost");
            return (Criteria) this;
        }

        public Criteria andFirstTelIsNull() {
            addCriterion("FIRST_TEL_ is null");
            return (Criteria) this;
        }

        public Criteria andFirstTelIsNotNull() {
            addCriterion("FIRST_TEL_ is not null");
            return (Criteria) this;
        }

        public Criteria andFirstTelEqualTo(String value) {
            addCriterion("FIRST_TEL_ =", value, "firstTel");
            return (Criteria) this;
        }

        public Criteria andFirstTelNotEqualTo(String value) {
            addCriterion("FIRST_TEL_ <>", value, "firstTel");
            return (Criteria) this;
        }

        public Criteria andFirstTelGreaterThan(String value) {
            addCriterion("FIRST_TEL_ >", value, "firstTel");
            return (Criteria) this;
        }

        public Criteria andFirstTelGreaterThanOrEqualTo(String value) {
            addCriterion("FIRST_TEL_ >=", value, "firstTel");
            return (Criteria) this;
        }

        public Criteria andFirstTelLessThan(String value) {
            addCriterion("FIRST_TEL_ <", value, "firstTel");
            return (Criteria) this;
        }

        public Criteria andFirstTelLessThanOrEqualTo(String value) {
            addCriterion("FIRST_TEL_ <=", value, "firstTel");
            return (Criteria) this;
        }

        public Criteria andFirstTelLike(String value) {
            addCriterion("FIRST_TEL_ like", value, "firstTel");
            return (Criteria) this;
        }

        public Criteria andFirstTelNotLike(String value) {
            addCriterion("FIRST_TEL_ not like", value, "firstTel");
            return (Criteria) this;
        }

        public Criteria andFirstTelIn(List<String> values) {
            addCriterion("FIRST_TEL_ in", values, "firstTel");
            return (Criteria) this;
        }

        public Criteria andFirstTelNotIn(List<String> values) {
            addCriterion("FIRST_TEL_ not in", values, "firstTel");
            return (Criteria) this;
        }

        public Criteria andFirstTelBetween(String value1, String value2) {
            addCriterion("FIRST_TEL_ between", value1, value2, "firstTel");
            return (Criteria) this;
        }

        public Criteria andFirstTelNotBetween(String value1, String value2) {
            addCriterion("FIRST_TEL_ not between", value1, value2, "firstTel");
            return (Criteria) this;
        }

        public Criteria andSecondManagerIsNull() {
            addCriterion("SECOND_MANAGER_ is null");
            return (Criteria) this;
        }

        public Criteria andSecondManagerIsNotNull() {
            addCriterion("SECOND_MANAGER_ is not null");
            return (Criteria) this;
        }

        public Criteria andSecondManagerEqualTo(String value) {
            addCriterion("SECOND_MANAGER_ =", value, "secondManager");
            return (Criteria) this;
        }

        public Criteria andSecondManagerNotEqualTo(String value) {
            addCriterion("SECOND_MANAGER_ <>", value, "secondManager");
            return (Criteria) this;
        }

        public Criteria andSecondManagerGreaterThan(String value) {
            addCriterion("SECOND_MANAGER_ >", value, "secondManager");
            return (Criteria) this;
        }

        public Criteria andSecondManagerGreaterThanOrEqualTo(String value) {
            addCriterion("SECOND_MANAGER_ >=", value, "secondManager");
            return (Criteria) this;
        }

        public Criteria andSecondManagerLessThan(String value) {
            addCriterion("SECOND_MANAGER_ <", value, "secondManager");
            return (Criteria) this;
        }

        public Criteria andSecondManagerLessThanOrEqualTo(String value) {
            addCriterion("SECOND_MANAGER_ <=", value, "secondManager");
            return (Criteria) this;
        }

        public Criteria andSecondManagerLike(String value) {
            addCriterion("SECOND_MANAGER_ like", value, "secondManager");
            return (Criteria) this;
        }

        public Criteria andSecondManagerNotLike(String value) {
            addCriterion("SECOND_MANAGER_ not like", value, "secondManager");
            return (Criteria) this;
        }

        public Criteria andSecondManagerIn(List<String> values) {
            addCriterion("SECOND_MANAGER_ in", values, "secondManager");
            return (Criteria) this;
        }

        public Criteria andSecondManagerNotIn(List<String> values) {
            addCriterion("SECOND_MANAGER_ not in", values, "secondManager");
            return (Criteria) this;
        }

        public Criteria andSecondManagerBetween(String value1, String value2) {
            addCriterion("SECOND_MANAGER_ between", value1, value2, "secondManager");
            return (Criteria) this;
        }

        public Criteria andSecondManagerNotBetween(String value1, String value2) {
            addCriterion("SECOND_MANAGER_ not between", value1, value2, "secondManager");
            return (Criteria) this;
        }

        public Criteria andSecondPostIsNull() {
            addCriterion("SECOND_POST_ is null");
            return (Criteria) this;
        }

        public Criteria andSecondPostIsNotNull() {
            addCriterion("SECOND_POST_ is not null");
            return (Criteria) this;
        }

        public Criteria andSecondPostEqualTo(String value) {
            addCriterion("SECOND_POST_ =", value, "secondPost");
            return (Criteria) this;
        }

        public Criteria andSecondPostNotEqualTo(String value) {
            addCriterion("SECOND_POST_ <>", value, "secondPost");
            return (Criteria) this;
        }

        public Criteria andSecondPostGreaterThan(String value) {
            addCriterion("SECOND_POST_ >", value, "secondPost");
            return (Criteria) this;
        }

        public Criteria andSecondPostGreaterThanOrEqualTo(String value) {
            addCriterion("SECOND_POST_ >=", value, "secondPost");
            return (Criteria) this;
        }

        public Criteria andSecondPostLessThan(String value) {
            addCriterion("SECOND_POST_ <", value, "secondPost");
            return (Criteria) this;
        }

        public Criteria andSecondPostLessThanOrEqualTo(String value) {
            addCriterion("SECOND_POST_ <=", value, "secondPost");
            return (Criteria) this;
        }

        public Criteria andSecondPostLike(String value) {
            addCriterion("SECOND_POST_ like", value, "secondPost");
            return (Criteria) this;
        }

        public Criteria andSecondPostNotLike(String value) {
            addCriterion("SECOND_POST_ not like", value, "secondPost");
            return (Criteria) this;
        }

        public Criteria andSecondPostIn(List<String> values) {
            addCriterion("SECOND_POST_ in", values, "secondPost");
            return (Criteria) this;
        }

        public Criteria andSecondPostNotIn(List<String> values) {
            addCriterion("SECOND_POST_ not in", values, "secondPost");
            return (Criteria) this;
        }

        public Criteria andSecondPostBetween(String value1, String value2) {
            addCriterion("SECOND_POST_ between", value1, value2, "secondPost");
            return (Criteria) this;
        }

        public Criteria andSecondPostNotBetween(String value1, String value2) {
            addCriterion("SECOND_POST_ not between", value1, value2, "secondPost");
            return (Criteria) this;
        }

        public Criteria andSecondTelIsNull() {
            addCriterion("SECOND_TEL_ is null");
            return (Criteria) this;
        }

        public Criteria andSecondTelIsNotNull() {
            addCriterion("SECOND_TEL_ is not null");
            return (Criteria) this;
        }

        public Criteria andSecondTelEqualTo(String value) {
            addCriterion("SECOND_TEL_ =", value, "secondTel");
            return (Criteria) this;
        }

        public Criteria andSecondTelNotEqualTo(String value) {
            addCriterion("SECOND_TEL_ <>", value, "secondTel");
            return (Criteria) this;
        }

        public Criteria andSecondTelGreaterThan(String value) {
            addCriterion("SECOND_TEL_ >", value, "secondTel");
            return (Criteria) this;
        }

        public Criteria andSecondTelGreaterThanOrEqualTo(String value) {
            addCriterion("SECOND_TEL_ >=", value, "secondTel");
            return (Criteria) this;
        }

        public Criteria andSecondTelLessThan(String value) {
            addCriterion("SECOND_TEL_ <", value, "secondTel");
            return (Criteria) this;
        }

        public Criteria andSecondTelLessThanOrEqualTo(String value) {
            addCriterion("SECOND_TEL_ <=", value, "secondTel");
            return (Criteria) this;
        }

        public Criteria andSecondTelLike(String value) {
            addCriterion("SECOND_TEL_ like", value, "secondTel");
            return (Criteria) this;
        }

        public Criteria andSecondTelNotLike(String value) {
            addCriterion("SECOND_TEL_ not like", value, "secondTel");
            return (Criteria) this;
        }

        public Criteria andSecondTelIn(List<String> values) {
            addCriterion("SECOND_TEL_ in", values, "secondTel");
            return (Criteria) this;
        }

        public Criteria andSecondTelNotIn(List<String> values) {
            addCriterion("SECOND_TEL_ not in", values, "secondTel");
            return (Criteria) this;
        }

        public Criteria andSecondTelBetween(String value1, String value2) {
            addCriterion("SECOND_TEL_ between", value1, value2, "secondTel");
            return (Criteria) this;
        }

        public Criteria andSecondTelNotBetween(String value1, String value2) {
            addCriterion("SECOND_TEL_ not between", value1, value2, "secondTel");
            return (Criteria) this;
        }

        public Criteria andMapLevelIsNull() {
            addCriterion("MAP_LEVEL_ is null");
            return (Criteria) this;
        }

        public Criteria andMapLevelIsNotNull() {
            addCriterion("MAP_LEVEL_ is not null");
            return (Criteria) this;
        }

        public Criteria andMapLevelEqualTo(String value) {
            addCriterion("MAP_LEVEL_ =", value, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelNotEqualTo(String value) {
            addCriterion("MAP_LEVEL_ <>", value, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelGreaterThan(String value) {
            addCriterion("MAP_LEVEL_ >", value, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelGreaterThanOrEqualTo(String value) {
            addCriterion("MAP_LEVEL_ >=", value, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelLessThan(String value) {
            addCriterion("MAP_LEVEL_ <", value, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelLessThanOrEqualTo(String value) {
            addCriterion("MAP_LEVEL_ <=", value, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelLike(String value) {
            addCriterion("MAP_LEVEL_ like", value, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelNotLike(String value) {
            addCriterion("MAP_LEVEL_ not like", value, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelIn(List<String> values) {
            addCriterion("MAP_LEVEL_ in", values, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelNotIn(List<String> values) {
            addCriterion("MAP_LEVEL_ not in", values, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelBetween(String value1, String value2) {
            addCriterion("MAP_LEVEL_ between", value1, value2, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andMapLevelNotBetween(String value1, String value2) {
            addCriterion("MAP_LEVEL_ not between", value1, value2, "mapLevel");
            return (Criteria) this;
        }

        public Criteria andPointIsNull() {
            addCriterion("POINT_ is null");
            return (Criteria) this;
        }

        public Criteria andPointIsNotNull() {
            addCriterion("POINT_ is not null");
            return (Criteria) this;
        }

        public Criteria andPointEqualTo(String value) {
            addCriterion("POINT_ =", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotEqualTo(String value) {
            addCriterion("POINT_ <>", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThan(String value) {
            addCriterion("POINT_ >", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThanOrEqualTo(String value) {
            addCriterion("POINT_ >=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThan(String value) {
            addCriterion("POINT_ <", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThanOrEqualTo(String value) {
            addCriterion("POINT_ <=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLike(String value) {
            addCriterion("POINT_ like", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotLike(String value) {
            addCriterion("POINT_ not like", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointIn(List<String> values) {
            addCriterion("POINT_ in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotIn(List<String> values) {
            addCriterion("POINT_ not in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointBetween(String value1, String value2) {
            addCriterion("POINT_ between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotBetween(String value1, String value2) {
            addCriterion("POINT_ not between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andOutlineIsNull() {
            addCriterion("OUTLINE_ is null");
            return (Criteria) this;
        }

        public Criteria andOutlineIsNotNull() {
            addCriterion("OUTLINE_ is not null");
            return (Criteria) this;
        }

        public Criteria andOutlineEqualTo(String value) {
            addCriterion("OUTLINE_ =", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineNotEqualTo(String value) {
            addCriterion("OUTLINE_ <>", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineGreaterThan(String value) {
            addCriterion("OUTLINE_ >", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineGreaterThanOrEqualTo(String value) {
            addCriterion("OUTLINE_ >=", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineLessThan(String value) {
            addCriterion("OUTLINE_ <", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineLessThanOrEqualTo(String value) {
            addCriterion("OUTLINE_ <=", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineLike(String value) {
            addCriterion("OUTLINE_ like", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineNotLike(String value) {
            addCriterion("OUTLINE_ not like", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineIn(List<String> values) {
            addCriterion("OUTLINE_ in", values, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineNotIn(List<String> values) {
            addCriterion("OUTLINE_ not in", values, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineBetween(String value1, String value2) {
            addCriterion("OUTLINE_ between", value1, value2, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineNotBetween(String value1, String value2) {
            addCriterion("OUTLINE_ not between", value1, value2, "outline");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("COLOR_ is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("COLOR_ is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("COLOR_ =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("COLOR_ <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("COLOR_ >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("COLOR_ >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("COLOR_ <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("COLOR_ <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("COLOR_ like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("COLOR_ not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("COLOR_ in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("COLOR_ not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("COLOR_ between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("COLOR_ not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME_ is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME_ is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME_ =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME_ <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME_ >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME_ >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME_ <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME_ <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME_ in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME_ not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME_ between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME_ not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME_ is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME_ is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME_ =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME_ <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME_ >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME_ >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME_ <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME_ <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME_ in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME_ not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME_ between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME_ not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andIsParentIsNull() {
            addCriterion("IS_PARENT is null");
            return (Criteria) this;
        }

        public Criteria andIsParentIsNotNull() {
            addCriterion("IS_PARENT is not null");
            return (Criteria) this;
        }

        public Criteria andIsParentEqualTo(Integer value) {
            addCriterion("IS_PARENT =", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotEqualTo(Integer value) {
            addCriterion("IS_PARENT <>", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentGreaterThan(Integer value) {
            addCriterion("IS_PARENT >", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_PARENT >=", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentLessThan(Integer value) {
            addCriterion("IS_PARENT <", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentLessThanOrEqualTo(Integer value) {
            addCriterion("IS_PARENT <=", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentIn(List<Integer> values) {
            addCriterion("IS_PARENT in", values, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotIn(List<Integer> values) {
            addCriterion("IS_PARENT not in", values, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentBetween(Integer value1, Integer value2) {
            addCriterion("IS_PARENT between", value1, value2, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_PARENT not between", value1, value2, "isParent");
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