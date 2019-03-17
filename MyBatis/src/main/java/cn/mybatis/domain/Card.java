package cn.mybatis.domain;

import java.io.Serializable;

public class Card implements Serializable {
    private Integer id; // 主键id
    private String code; // 身份证编号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}