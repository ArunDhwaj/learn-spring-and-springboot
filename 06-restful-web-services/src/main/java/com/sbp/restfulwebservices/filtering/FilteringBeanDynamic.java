package com.sbp.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFilter("FilteringBeanDynamic")
public class FilteringBeanDynamic {

    private String field1;

    private String field2;

    private String password;

    public FilteringBeanDynamic(String field1, String field2, String password) {
        this.field1 = field1;
        this.field2 = field2;
        this.password = password;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "FilteringBeanDynamic{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
