package com.da.springbootdemo1.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String name;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "date=" + date +
                ", name='" + name + '\'' +
                '}';
    }
}
