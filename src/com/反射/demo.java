package com.反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 风亦未止
 */
public class demo {

    static class Person{
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age,Integer a,Integer b) {
            this.age = age;
        }
        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Person person = Person.class.newInstance();
        person.setAge(123);
        person.setName("123");
        Class<?> aClass = person.getClass();
        Method getName = aClass.getMethod("getName");
        Method setAge = aClass.getMethod("setAge", Integer.class,Integer.class,Integer.class);
        String invoke = (String) getName.invoke(person);
        setAge.invoke(person,1121,12,22);
        System.out.println(person.getAge());
    }

}
