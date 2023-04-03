package com.lambda;

import com.lambda.自定义List.MyList;

/**
 * @author 风亦未止
 * @date 2022/11/5 15:55
 */
public class 自定义的lsit {


    public static void main(String[] args) {
        MyList<Person> list = new MyList<>();
        Person person1 = new Person("小明", 12);
        list.add(person1);
        Person person2 = new Person("小红", 14);
        list.add(person2);
        Person person3 = new Person("张三", 15);
        list.add(person3);
        Person person4 = new Person("老刘", 22);
        list.add(person4);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
        //筛选年龄大于13的对象
        MyList<Person> filter1 = list.filter(a -> {
            return a.getAge() > 13;
        });
        System.out.println("筛选年龄大于13的对象: ");
        for (int i = 0; i < filter1.size(); i++) {
            System.out.println(filter1.get(i).toString());
        }
        //筛选名字带“小”的对象
        MyList<Person> filter2 = list.filter(a -> {
            return a.getName().contains("小");
        });
        System.out.println("筛选名字带“小”的对象: ");
        for (int i = 0; i < filter2.size(); i++) {
            System.out.println(filter2.get(i).toString());
        }

//       MyList<Integer> list =  new MyList<>(10);
//       for(int i = 0; i <= 10; i ++){
//           list.add(i);
//       }
//       for(int i = 0 ; i < list.size(); i ++){
//           System.out.print(list.get(i) + ", ");
//       }
//        System.out.println();
//        MyList<Integer> filter = list.filter((a) -> {
//            return a % 2 == 0;
//        });
//        filter.removeByIndex(2);
//        filter.add(111);
//        for(int i = 0 ; i < filter.size(); i ++){
//            System.out.print(filter.get(i) + ", ");
//        }


    }

    static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
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

}
