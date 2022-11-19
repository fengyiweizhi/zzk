package com.zzk.demo7;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

/**
 * json解析Gson和fastJSON
 * @author 风亦未止
 */
public class Demo1 {
    public static void main(String[] args) {
        /**
         * Gson
         */
        //创建gson对象
        Gson g=new Gson();
        //转换为json格式
        Person person = new Person("老王", 18, "男");
        String s = g.toJson(person);
        //打印
        System.out.println(s);
        //json转换为对象
        Person person1 = g.fromJson("{\"name\":\"老王\",\"age\":18,\"sex\":\"男\"}", Person.class);
        System.out.println(person1.toString());
        //json转换为集合
        HashMap hashMap = g.fromJson("{\"name\":\"老王\",\"age\":18,\"sex\":\"男\"}", HashMap.class);
        System.out.println(hashMap.get("name"));

        /**
         * fastjson
         */
        //转换为json
        String s1 = JSON.toJSONString(person);
        System.out.println(s1);
        //转为对象
        Person person2 = JSON.parseObject("{\"age\":18,\"name\":\"老王\",\"sex\":\"男\"}", Person.class);
        String name = person2.getName();
        System.out.println(name);
        //转换为集合
        HashMap hashMap1 = JSON.parseObject("{\"age\":18,\"name\":\"老王\",\"sex\":\"男\"}", HashMap.class);
        System.out.println(hashMap1.get("age"));
        //转换为数组
        List<String> strings = JSON.parseArray("[\"hahah\",\"heiehi\",\"oooooo\"]", String.class);
        System.out.println(strings.get(2));
    }
}
class Person{
    private String name;
    private int age;
    private String sex;

    public Person() {
    }

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}