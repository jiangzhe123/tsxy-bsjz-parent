package tsxy.bsjz.platform.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HandleRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HandleRecordExample() {
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

        public Criteria andHandleNameIsNull() {
            addCriterion("handleName is null");
            return (Criteria) this;
        }

        public Criteria andHandleNameIsNotNull() {
            addCriterion("handleName is not null");
            return (Criteria) this;
        }

        public Criteria andHandleNameEqualTo(String value) {
            addCriterion("handleName =", value, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameNotEqualTo(String value) {
            addCriterion("handleName <>", value, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameGreaterThan(String value) {
            addCriterion("handleName >", value, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameGreaterThanOrEqualTo(String value) {
            addCriterion("handleName >=", value, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameLessThan(String value) {
            addCriterion("handleName <", value, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameLessThanOrEqualTo(String value) {
            addCriterion("handleName <=", value, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameLike(String value) {
            addCriterion("handleName like", value, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameNotLike(String value) {
            addCriterion("handleName not like", value, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameIn(List<String> values) {
            addCriterion("handleName in", values, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameNotIn(List<String> values) {
            addCriterion("handleName not in", values, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameBetween(String value1, String value2) {
            addCriterion("handleName between", value1, value2, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleNameNotBetween(String value1, String value2) {
            addCriterion("handleName not between", value1, value2, "handleName");
            return (Criteria) this;
        }

        public Criteria andHandleRoleIsNull() {
            addCriterion("handleRole is null");
            return (Criteria) this;
        }

        public Criteria andHandleRoleIsNotNull() {
            addCriterion("handleRole is not null");
            return (Criteria) this;
        }

        public Criteria andHandleRoleEqualTo(String value) {
            addCriterion("handleRole =", value, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleNotEqualTo(String value) {
            addCriterion("handleRole <>", value, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleGreaterThan(String value) {
            addCriterion("handleRole >", value, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleGreaterThanOrEqualTo(String value) {
            addCriterion("handleRole >=", value, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleLessThan(String value) {
            addCriterion("handleRole <", value, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleLessThanOrEqualTo(String value) {
            addCriterion("handleRole <=", value, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleLike(String value) {
            addCriterion("handleRole like", value, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleNotLike(String value) {
            addCriterion("handleRole not like", value, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleIn(List<String> values) {
            addCriterion("handleRole in", values, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleNotIn(List<String> values) {
            addCriterion("handleRole not in", values, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleBetween(String value1, String value2) {
            addCriterion("handleRole between", value1, value2, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleRoleNotBetween(String value1, String value2) {
            addCriterion("handleRole not between", value1, value2, "handleRole");
            return (Criteria) this;
        }

        public Criteria andHandleContentIsNull() {
            addCriterion("handleContent is null");
            return (Criteria) this;
        }

        public Criteria andHandleContentIsNotNull() {
            addCriterion("handleContent is not null");
            return (Criteria) this;
        }

        public Criteria andHandleContentEqualTo(String value) {
            addCriterion("handleContent =", value, "handleContent");
            return (Criteria) this;
        }

        public Criteria andHandleContentNotEqualTo(String value) {
            addCriterion("handleContent <>", value, "handleContent");
            return (Criteria) this;
        }

        public Criteria andHandleContentGreaterThan(String value) {
            addCriterion("handleContent >", value, "handleContent");
            return (Criteria) this;
        }

        public Criteria andHandleContentGreaterThanOrEqualTo(String value) {
            addCriterion("handleContent >=", value, "handleContent");
            return (Criteria) this;
        }

        public Criteria andHandleContentLessThan(String value) {
            addCriterion("handleContent <", value, "handleContent");
            return (Criteria) this;
        }

        public Criteria andHandleContentLessThanOrEqualTo(String value) {
            addCriterion("handleContent <=", value, "handleContent");
            return (Criteria) this;
        }

        public Criteria andHandleContentLike(String value) {
            addCriterion("handleContent like", value, "handleContent");
            return (Criteria) this;
        }

        public Criteria andHandleContentNotLike(String value) {
            addCriterion("handleContent not like", value, "handleContent");
            return (Criteria) this;
        }

        public Criteria andHandleContentIn(List<String> values) {
            addCriterion("handleContent in", values, "handleContent");
            return (Criteria) this;
        }

        public Criteria andHandleContentNotIn(List<String> values) {
            addCriterion("handleContent not in", values, "handleContent");
            return (Criteria) this;
        }

        public Criteria andHandleContentBetween(String value1, String value2) {
            addCriterion("handleContent between", value1, value2, "handleContent");
            return (Criteria) this;
        }

        public Criteria andHandleContentNotBetween(String value1, String value2) {
            addCriterion("handleContent not between", value1, value2, "handleContent");
            return (Criteria) this;
        }

        public Criteria andHandleDateIsNull() {
            addCriterion("handleDate is null");
            return (Criteria) this;
        }

        public Criteria andHandleDateIsNotNull() {
            addCriterion("handleDate is not null");
            return (Criteria) this;
        }

        public Criteria andHandleDateEqualTo(Date value) {
            addCriterion("handleDate =", value, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateNotEqualTo(Date value) {
            addCriterion("handleDate <>", value, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateGreaterThan(Date value) {
            addCriterion("handleDate >", value, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateGreaterThanOrEqualTo(Date value) {
            addCriterion("handleDate >=", value, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateLessThan(Date value) {
            addCriterion("handleDate <", value, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateLessThanOrEqualTo(Date value) {
            addCriterion("handleDate <=", value, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateIn(List<Date> values) {
            addCriterion("handleDate in", values, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateNotIn(List<Date> values) {
            addCriterion("handleDate not in", values, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateBetween(Date value1, Date value2) {
            addCriterion("handleDate between", value1, value2, "handleDate");
            return (Criteria) this;
        }

        public Criteria andHandleDateNotBetween(Date value1, Date value2) {
            addCriterion("handleDate not between", value1, value2, "handleDate");
            return (Criteria) this;
        }

        public Criteria andDeleteStateIsNull() {
            addCriterion("deleteState is null");
            return (Criteria) this;
        }

        public Criteria andDeleteStateIsNotNull() {
            addCriterion("deleteState is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteStateEqualTo(Integer value) {
            addCriterion("deleteState =", value, "deleteState");
            return (Criteria) this;
        }

        public Criteria andDeleteStateNotEqualTo(Integer value) {
            addCriterion("deleteState <>", value, "deleteState");
            return (Criteria) this;
        }

        public Criteria andDeleteStateGreaterThan(Integer value) {
            addCriterion("deleteState >", value, "deleteState");
            return (Criteria) this;
        }

        public Criteria andDeleteStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("deleteState >=", value, "deleteState");
            return (Criteria) this;
        }

        public Criteria andDeleteStateLessThan(Integer value) {
            addCriterion("deleteState <", value, "deleteState");
            return (Criteria) this;
        }

        public Criteria andDeleteStateLessThanOrEqualTo(Integer value) {
            addCriterion("deleteState <=", value, "deleteState");
            return (Criteria) this;
        }

        public Criteria andDeleteStateIn(List<Integer> values) {
            addCriterion("deleteState in", values, "deleteState");
            return (Criteria) this;
        }

        public Criteria andDeleteStateNotIn(List<Integer> values) {
            addCriterion("deleteState not in", values, "deleteState");
            return (Criteria) this;
        }

        public Criteria andDeleteStateBetween(Integer value1, Integer value2) {
            addCriterion("deleteState between", value1, value2, "deleteState");
            return (Criteria) this;
        }

        public Criteria andDeleteStateNotBetween(Integer value1, Integer value2) {
            addCriterion("deleteState not between", value1, value2, "deleteState");
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