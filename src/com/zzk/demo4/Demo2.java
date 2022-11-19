package com.zzk.demo4;

/**
 * 试题二,存信息
 * @author 风亦未止
 */
public class Demo2 {
    public static void main(String[] args) {
        String s="name=王五 age=18 classNum=1101";
        String[] result=split(s);
        String name = result[0];
        int age=Integer.parseInt(result[1]);
        int classNum=Integer.parseInt(result[2]);
        Student student = new Student(name,age,classNum);
        System.out.println("姓名："+student.getName()+" 年龄："+student.getAge()+" 班级："+student.getClassNum());

    }
    public static String[] split(String s){
        //第一次拆分
        String[] one=s.split(" ");
        String[] result=new String[3];
        for(int a = 0;a<one.length;a++){
            //二次拆分
            String[] two= one[a].split("=");
            result[a]=two[1];
        }
        return result;
    }
}
class Student{
    private String name;
    private int age;
    private int classNum;

    public Student(String name, int age, int classNum) {
        this.name = name;
        this.age = age;
        this.classNum = classNum;
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

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }
}
