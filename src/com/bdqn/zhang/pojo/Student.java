package com.bdqn.zhang.pojo;

import java.util.Date;

public class Student {

    private Integer id;
    private String name;
    private Date birthday;
    private String sex;
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getSex() {
        return sex;
    }
}
