package tsxy.bsjz.platform.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DetailedMedicineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DetailedMedicineExample() {
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

        public Criteria andDetailedIdIsNull() {
            addCriterion("detailedId is null");
            return (Criteria) this;
        }

        public Criteria andDetailedIdIsNotNull() {
            addCriterion("detailedId is not null");
            return (Criteria) this;
        }

        public Criteria andDetailedIdEqualTo(Integer value) {
            addCriterion("detailedId =", value, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedIdNotEqualTo(Integer value) {
            addCriterion("detailedId <>", value, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedIdGreaterThan(Integer value) {
            addCriterion("detailedId >", value, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("detailedId >=", value, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedIdLessThan(Integer value) {
            addCriterion("detailedId <", value, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedIdLessThanOrEqualTo(Integer value) {
            addCriterion("detailedId <=", value, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedIdIn(List<Integer> values) {
            addCriterion("detailedId in", values, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedIdNotIn(List<Integer> values) {
            addCriterion("detailedId not in", values, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedIdBetween(Integer value1, Integer value2) {
            addCriterion("detailedId between", value1, value2, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedIdNotBetween(Integer value1, Integer value2) {
            addCriterion("detailedId not between", value1, value2, "detailedId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdIsNull() {
            addCriterion("medicineId is null");
            return (Criteria) this;
        }

        public Criteria andMedicineIdIsNotNull() {
            addCriterion("medicineId is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineIdEqualTo(Integer value) {
            addCriterion("medicineId =", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdNotEqualTo(Integer value) {
            addCriterion("medicineId <>", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdGreaterThan(Integer value) {
            addCriterion("medicineId >", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("medicineId >=", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdLessThan(Integer value) {
            addCriterion("medicineId <", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdLessThanOrEqualTo(Integer value) {
            addCriterion("medicineId <=", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdIn(List<Integer> values) {
            addCriterion("medicineId in", values, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdNotIn(List<Integer> values) {
            addCriterion("medicineId not in", values, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdBetween(Integer value1, Integer value2) {
            addCriterion("medicineId between", value1, value2, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdNotBetween(Integer value1, Integer value2) {
            addCriterion("medicineId not between", value1, value2, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineNumIsNull() {
            addCriterion("medicineNum is null");
            return (Criteria) this;
        }

        public Criteria andMedicineNumIsNotNull() {
            addCriterion("medicineNum is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineNumEqualTo(Integer value) {
            addCriterion("medicineNum =", value, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineNumNotEqualTo(Integer value) {
            addCriterion("medicineNum <>", value, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineNumGreaterThan(Integer value) {
            addCriterion("medicineNum >", value, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("medicineNum >=", value, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineNumLessThan(Integer value) {
            addCriterion("medicineNum <", value, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineNumLessThanOrEqualTo(Integer value) {
            addCriterion("medicineNum <=", value, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineNumIn(List<Integer> values) {
            addCriterion("medicineNum in", values, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineNumNotIn(List<Integer> values) {
            addCriterion("medicineNum not in", values, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineNumBetween(Integer value1, Integer value2) {
            addCriterion("medicineNum between", value1, value2, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineNumNotBetween(Integer value1, Integer value2) {
            addCriterion("medicineNum not between", value1, value2, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceIsNull() {
            addCriterion("medicinePrice is null");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceIsNotNull() {
            addCriterion("medicinePrice is not null");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceEqualTo(BigDecimal value) {
            addCriterion("medicinePrice =", value, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceNotEqualTo(BigDecimal value) {
            addCriterion("medicinePrice <>", value, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceGreaterThan(BigDecimal value) {
            addCriterion("medicinePrice >", value, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("medicinePrice >=", value, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceLessThan(BigDecimal value) {
            addCriterion("medicinePrice <", value, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("medicinePrice <=", value, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceIn(List<BigDecimal> values) {
            addCriterion("medicinePrice in", values, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceNotIn(List<BigDecimal> values) {
            addCriterion("medicinePrice not in", values, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("medicinePrice between", value1, value2, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("medicinePrice not between", value1, value2, "medicinePrice");
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