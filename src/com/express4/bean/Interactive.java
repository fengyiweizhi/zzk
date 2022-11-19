package com.express4.bean;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 服务端与客户端交互类
 * @author 风亦未止
 */
public class Interactive implements Serializable {
    //请求的标记
    private String flag;
    //传输多个快递数据
    private HashMap<Integer,Express> list=new HashMap<>();
    //传输一个快递数据
    private Express express;

    public Interactive(Express express) {
        this.express = express;
    }

    public Interactive(String flag, HashMap<Integer, Express> list) {
        this.flag = flag;
        this.list = list;
    }

    public Interactive(String flag, Express express) {
        this.flag = flag;
        this.express = express;
    }

    public Interactive(HashMap<Integer, Express> list) {
        this.list = list;
    }

    public Interactive(String flag) {
        this.flag = flag;
    }

    public Express getExpress() {
        return express;
    }

    public void setExpress(Express express) {
        this.express = express;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public HashMap<Integer, Express> getList() {
        return list;
    }

    public void setList(HashMap<Integer, Express> list) {
        this.list = list;
    }
}
