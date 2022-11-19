package com.zzk.Demo5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author 风亦未止
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        /*FileInputStream fis=new FileInputStream("D:\\a.txt");
        byte a=(byte)fis.read();
        fis.close();
        System.out.println(a);

        List<Integer> myList=new ArrayList<>();//实例化List对象
        myList.add(0,2);//此方法调用的是List接口下的
        myList.add(1);
        myList.remove(1);//1为下标
        for (Integer b:myList){//此循环为foreach循环放入数组对象可方便的实现遍历操作
            System.out.println(b);
        }
        System.out.println(myList);//调用的是toString方法输出的



        Set<String> mySet=new HashSet<>();
        mySet.add("A");
        mySet.add("B");
        mySet.add("C");
        mySet.add("D");
        String[] s=mySet.toArray(new String[]{});
        for(String c:s){
            System.out.println(c);
        }
        System.out.println(mySet);*/

      /*  Set<String> mySet2=new TreeSet<>();
        mySet2.add("c");
        mySet2.add("b");
        mySet2.add("a");
        System.out.println(mySet2);
*/

       /* Person person = new Person("张三", 20, "女");
        Person person1 = new Person("李四", 18, "男");
        Person person2 = new Person("老五", 21, "男");
        Set<Person> mySet2=new TreeSet<>();
        mySet2.add(person);
        mySet2.add(person1);
        mySet2.add(person2);
        Iterator<Person> iterator=mySet2.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        Map<Integer,Person> map=new HashMap<>();
        Person person = new Person("张三", 20, "女");
        Person person1 = new Person("李四", 18, "男");
        Person person2 = new Person("老五", 21, "男");
        map.put(1,person);
        map.put(2,person1);
        map.put(3,person2);
        Set<Integer> set=map.keySet();//获取全部的键
        Iterator<Integer> iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(map.get(iterator.next()));
        }
    }
}

class Person implements Comparable<Person>{
     private String name;
     private int age;
     private String sex;


    @Override
    public int compareTo(Person o) {
        if (this.age > o.age) {
            return 1;
        } else if (this.age < o.age) {
            return -1;
        } else {
            return 0;
        }
    }
    @Override
    public String toString() {
        return "姓名='" + name + '\'' +
                ", 年龄=" + age +
                ", 性别='" + sex + '\'';
    }

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

