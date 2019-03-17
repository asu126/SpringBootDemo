package cn.mybatis.domain;

import java.io.Serializable;

public class Person implements Serializable {
    // 主键id
    private Integer id;
    // 姓名
    private String name;
    // 性别
    private String sex;
    // 年龄
    private Integer age;
    // 人和身份证是一对一的关系，即一个人只有一个身份证
    private Card card;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}