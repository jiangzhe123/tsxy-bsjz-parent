package tsxy.bsjz.platform.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientFeedbackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PatientFeedbackExample() {
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

        public Criteria andPatientIdIsNull() {
            addCriterion("patientId is null");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNotNull() {
            addCriterion("patientId is not null");
            return (Criteria) this;
        }

        public Criteria andPatientIdEqualTo(Integer value) {
            addCriterion("patientId =", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotEqualTo(Integer value) {
            addCriterion("patientId <>", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThan(Integer value) {
            addCriterion("patientId >", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("patientId >=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThan(Integer value) {
            addCriterion("patientId <", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThanOrEqualTo(Integer value) {
            addCriterion("patientId <=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIn(List<Integer> values) {
            addCriterion("patientId in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotIn(List<Integer> values) {
            addCriterion("patientId not in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdBetween(Integer value1, Integer value2) {
            addCriterion("patientId between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotBetween(Integer value1, Integer value2) {
            addCriterion("patientId not between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentIsNull() {
            addCriterion("feedbackContent is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentIsNotNull() {
            addCriterion("feedbackContent is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentEqualTo(String value) {
            addCriterion("feedbackContent =", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentNotEqualTo(String value) {
            addCriterion("feedbackContent <>", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentGreaterThan(String value) {
            addCriterion("feedbackContent >", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentGreaterThanOrEqualTo(String value) {
            addCriterion("feedbackContent >=", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentLessThan(String value) {
            addCriterion("feedbackContent <", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentLessThanOrEqualTo(String value) {
            addCriterion("feedbackContent <=", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentLike(String value) {
            addCriterion("feedbackContent like", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentNotLike(String value) {
            addCriterion("feedbackContent not like", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentIn(List<String> values) {
            addCriterion("feedbackContent in", values, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentNotIn(List<String> values) {
            addCriterion("feedbackContent not in", values, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentBetween(String value1, String value2) {
            addCriterion("feedbackContent between", value1, value2, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentNotBetween(String value1, String value2) {
            addCriterion("feedbackContent not between", value1, value2, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackDateIsNull() {
            addCriterion("feedbackDate is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackDateIsNotNull() {
            addCriterion("feedbackDate is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackDateEqualTo(Date value) {
            addCriterion("feedbackDate =", value, "feedbackDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackDateNotEqualTo(Date value) {
            addCriterion("feedbackDate <>", value, "feedbackDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackDateGreaterThan(Date value) {
            addCriterion("feedbackDate >", value, "feedbackDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackDateGreaterThanOrEqualTo(Date value) {
            addCriterion("feedbackDate >=", value, "feedbackDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackDateLessThan(Date value) {
            addCriterion("feedbackDate <", value, "feedbackDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackDateLessThanOrEqualTo(Date value) {
            addCriterion("feedbackDate <=", value, "feedbackDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackDateIn(List<Date> values) {
            addCriterion("feedbackDate in", values, "feedbackDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackDateNotIn(List<Date> values) {
            addCriterion("feedbackDate not in", values, "feedbackDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackDateBetween(Date value1, Date value2) {
            addCriterion("feedbackDate between", value1, value2, "feedbackDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackDateNotBetween(Date value1, Date value2) {
            addCriterion("feedbackDate not between", value1, value2, "feedbackDate");
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