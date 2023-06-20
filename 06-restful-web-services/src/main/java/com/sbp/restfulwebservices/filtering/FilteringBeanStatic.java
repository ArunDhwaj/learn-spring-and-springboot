package com.sbp.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties({"field1", "field2"})
public class FilteringBeanStatic {
    private String field1;

    @JsonProperty("my_field2")
    private String field2;

    @JsonIgnore
    private String password;

    public FilteringBeanStatic(String field1, String field2, String password) {
        this.field1 = field1;
        this.field2 = field2;
        this.password = password;
    }

    public String getfield1() {
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
        return "FilteringBean{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
