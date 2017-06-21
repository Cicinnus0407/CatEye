package com.cicinnus.cateye.module.cinema.bean;

/**
 *
 */

public class SortConditionBean {
    private String name;
    private String code;//rating/price/distance
    public boolean isSelect;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
