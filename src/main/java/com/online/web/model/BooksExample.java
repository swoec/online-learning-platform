package main.java.com.online.web.model;

import java.util.ArrayList;
import java.util.List;

public class BooksExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BooksExample() {
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

        public Criteria andBidIsNull() {
            addCriterion("bid is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bid is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Integer value) {
            addCriterion("bid =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Integer value) {
            addCriterion("bid <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Integer value) {
            addCriterion("bid >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Integer value) {
            addCriterion("bid <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Integer value) {
            addCriterion("bid <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Integer> values) {
            addCriterion("bid in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Integer> values) {
            addCriterion("bid not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Integer value1, Integer value2) {
            addCriterion("bid between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Integer value1, Integer value2) {
            addCriterion("bid not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBnameIsNull() {
            addCriterion("bname is null");
            return (Criteria) this;
        }

        public Criteria andBnameIsNotNull() {
            addCriterion("bname is not null");
            return (Criteria) this;
        }

        public Criteria andBnameEqualTo(String value) {
            addCriterion("bname =", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotEqualTo(String value) {
            addCriterion("bname <>", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameGreaterThan(String value) {
            addCriterion("bname >", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameGreaterThanOrEqualTo(String value) {
            addCriterion("bname >=", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLessThan(String value) {
            addCriterion("bname <", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLessThanOrEqualTo(String value) {
            addCriterion("bname <=", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLike(String value) {
            addCriterion("bname like", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotLike(String value) {
            addCriterion("bname not like", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameIn(List<String> values) {
            addCriterion("bname in", values, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotIn(List<String> values) {
            addCriterion("bname not in", values, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameBetween(String value1, String value2) {
            addCriterion("bname between", value1, value2, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotBetween(String value1, String value2) {
            addCriterion("bname not between", value1, value2, "bname");
            return (Criteria) this;
        }

        public Criteria andBdescIsNull() {
            addCriterion("bdesc is null");
            return (Criteria) this;
        }

        public Criteria andBdescIsNotNull() {
            addCriterion("bdesc is not null");
            return (Criteria) this;
        }

        public Criteria andBdescEqualTo(String value) {
            addCriterion("bdesc =", value, "bdesc");
            return (Criteria) this;
        }

        public Criteria andBdescNotEqualTo(String value) {
            addCriterion("bdesc <>", value, "bdesc");
            return (Criteria) this;
        }

        public Criteria andBdescGreaterThan(String value) {
            addCriterion("bdesc >", value, "bdesc");
            return (Criteria) this;
        }

        public Criteria andBdescGreaterThanOrEqualTo(String value) {
            addCriterion("bdesc >=", value, "bdesc");
            return (Criteria) this;
        }

        public Criteria andBdescLessThan(String value) {
            addCriterion("bdesc <", value, "bdesc");
            return (Criteria) this;
        }

        public Criteria andBdescLessThanOrEqualTo(String value) {
            addCriterion("bdesc <=", value, "bdesc");
            return (Criteria) this;
        }

        public Criteria andBdescLike(String value) {
            addCriterion("bdesc like", value, "bdesc");
            return (Criteria) this;
        }

        public Criteria andBdescNotLike(String value) {
            addCriterion("bdesc not like", value, "bdesc");
            return (Criteria) this;
        }

        public Criteria andBdescIn(List<String> values) {
            addCriterion("bdesc in", values, "bdesc");
            return (Criteria) this;
        }

        public Criteria andBdescNotIn(List<String> values) {
            addCriterion("bdesc not in", values, "bdesc");
            return (Criteria) this;
        }

        public Criteria andBdescBetween(String value1, String value2) {
            addCriterion("bdesc between", value1, value2, "bdesc");
            return (Criteria) this;
        }

        public Criteria andBdescNotBetween(String value1, String value2) {
            addCriterion("bdesc not between", value1, value2, "bdesc");
            return (Criteria) this;
        }

        public Criteria andBlinkIsNull() {
            addCriterion("blink is null");
            return (Criteria) this;
        }

        public Criteria andBlinkIsNotNull() {
            addCriterion("blink is not null");
            return (Criteria) this;
        }

        public Criteria andBlinkEqualTo(String value) {
            addCriterion("blink =", value, "blink");
            return (Criteria) this;
        }

        public Criteria andBlinkNotEqualTo(String value) {
            addCriterion("blink <>", value, "blink");
            return (Criteria) this;
        }

        public Criteria andBlinkGreaterThan(String value) {
            addCriterion("blink >", value, "blink");
            return (Criteria) this;
        }

        public Criteria andBlinkGreaterThanOrEqualTo(String value) {
            addCriterion("blink >=", value, "blink");
            return (Criteria) this;
        }

        public Criteria andBlinkLessThan(String value) {
            addCriterion("blink <", value, "blink");
            return (Criteria) this;
        }

        public Criteria andBlinkLessThanOrEqualTo(String value) {
            addCriterion("blink <=", value, "blink");
            return (Criteria) this;
        }

        public Criteria andBlinkLike(String value) {
            addCriterion("blink like", value, "blink");
            return (Criteria) this;
        }

        public Criteria andBlinkNotLike(String value) {
            addCriterion("blink not like", value, "blink");
            return (Criteria) this;
        }

        public Criteria andBlinkIn(List<String> values) {
            addCriterion("blink in", values, "blink");
            return (Criteria) this;
        }

        public Criteria andBlinkNotIn(List<String> values) {
            addCriterion("blink not in", values, "blink");
            return (Criteria) this;
        }

        public Criteria andBlinkBetween(String value1, String value2) {
            addCriterion("blink between", value1, value2, "blink");
            return (Criteria) this;
        }

        public Criteria andBlinkNotBetween(String value1, String value2) {
            addCriterion("blink not between", value1, value2, "blink");
            return (Criteria) this;
        }

        public Criteria andBlocationIsNull() {
            addCriterion("blocation is null");
            return (Criteria) this;
        }

        public Criteria andBlocationIsNotNull() {
            addCriterion("blocation is not null");
            return (Criteria) this;
        }

        public Criteria andBlocationEqualTo(String value) {
            addCriterion("blocation =", value, "blocation");
            return (Criteria) this;
        }

        public Criteria andBlocationNotEqualTo(String value) {
            addCriterion("blocation <>", value, "blocation");
            return (Criteria) this;
        }

        public Criteria andBlocationGreaterThan(String value) {
            addCriterion("blocation >", value, "blocation");
            return (Criteria) this;
        }

        public Criteria andBlocationGreaterThanOrEqualTo(String value) {
            addCriterion("blocation >=", value, "blocation");
            return (Criteria) this;
        }

        public Criteria andBlocationLessThan(String value) {
            addCriterion("blocation <", value, "blocation");
            return (Criteria) this;
        }

        public Criteria andBlocationLessThanOrEqualTo(String value) {
            addCriterion("blocation <=", value, "blocation");
            return (Criteria) this;
        }

        public Criteria andBlocationLike(String value) {
            addCriterion("blocation like", value, "blocation");
            return (Criteria) this;
        }

        public Criteria andBlocationNotLike(String value) {
            addCriterion("blocation not like", value, "blocation");
            return (Criteria) this;
        }

        public Criteria andBlocationIn(List<String> values) {
            addCriterion("blocation in", values, "blocation");
            return (Criteria) this;
        }

        public Criteria andBlocationNotIn(List<String> values) {
            addCriterion("blocation not in", values, "blocation");
            return (Criteria) this;
        }

        public Criteria andBlocationBetween(String value1, String value2) {
            addCriterion("blocation between", value1, value2, "blocation");
            return (Criteria) this;
        }

        public Criteria andBlocationNotBetween(String value1, String value2) {
            addCriterion("blocation not between", value1, value2, "blocation");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBpicIsNull() {
            addCriterion("bpic is null");
            return (Criteria) this;
        }

        public Criteria andBpicIsNotNull() {
            addCriterion("bpic is not null");
            return (Criteria) this;
        }

        public Criteria andBpicEqualTo(String value) {
            addCriterion("bpic =", value, "bpic");
            return (Criteria) this;
        }

        public Criteria andBpicNotEqualTo(String value) {
            addCriterion("bpic <>", value, "bpic");
            return (Criteria) this;
        }

        public Criteria andBpicGreaterThan(String value) {
            addCriterion("bpic >", value, "bpic");
            return (Criteria) this;
        }

        public Criteria andBpicGreaterThanOrEqualTo(String value) {
            addCriterion("bpic >=", value, "bpic");
            return (Criteria) this;
        }

        public Criteria andBpicLessThan(String value) {
            addCriterion("bpic <", value, "bpic");
            return (Criteria) this;
        }

        public Criteria andBpicLessThanOrEqualTo(String value) {
            addCriterion("bpic <=", value, "bpic");
            return (Criteria) this;
        }

        public Criteria andBpicLike(String value) {
            addCriterion("bpic like", value, "bpic");
            return (Criteria) this;
        }

        public Criteria andBpicNotLike(String value) {
            addCriterion("bpic not like", value, "bpic");
            return (Criteria) this;
        }

        public Criteria andBpicIn(List<String> values) {
            addCriterion("bpic in", values, "bpic");
            return (Criteria) this;
        }

        public Criteria andBpicNotIn(List<String> values) {
            addCriterion("bpic not in", values, "bpic");
            return (Criteria) this;
        }

        public Criteria andBpicBetween(String value1, String value2) {
            addCriterion("bpic between", value1, value2, "bpic");
            return (Criteria) this;
        }

        public Criteria andBpicNotBetween(String value1, String value2) {
            addCriterion("bpic not between", value1, value2, "bpic");
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