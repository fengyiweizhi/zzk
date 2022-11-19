package com.express.bean;

import java.util.Objects;

/**
 * 快递信息
 * @author 风亦未止
 */
public class Express {
    //快递公司
    private String company;
    //快递单号
    private String num;
    //取件码
    private int code;

    public Express() {
    }

    public Express(String num) {
        this.num = num;
    }

    public Express(String company, String num, int code) {
        this.company = company;
        this.num = num;
        this.code = code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Express express = (Express) o;
        return num.equals(express.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public String toString() {
        return "Express{" +
                "company='" + company + '\'' +
                ", num=" + num +
                ", code=" + code +
                '}';
    }
}
