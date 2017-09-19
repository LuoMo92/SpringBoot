package com.luomo.study.spring.boot.chapter2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by LiuMei on 2017-09-19.
 */
@Component
public class BlogProperties {

    //加载配置文件自定义属性
    @Value("${blog.name}")
    private String name;

    @Value("${blog.title}")
    private String title;

    @Value("${blog.desc}")
    private String desc;

    @Value("${blog.value}")
    private String value;

    @Value("${blog.number}")
    private Integer number;

    @Value("${blog.bignumber}")
    private Long bigNumber;

    @Value("${blog.within10}")
    private Integer within10;

    @Value("${blog.between}")
    private Integer between;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getBigNumber() {
        return bigNumber;
    }

    public void setBigNumber(Long bigNumber) {
        this.bigNumber = bigNumber;
    }

    public Integer getWithin10() {
        return within10;
    }

    public void setWithin10(Integer within10) {
        this.within10 = within10;
    }

    public Integer getBetween() {
        return between;
    }

    public void setBetween(Integer between) {
        this.between = between;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
