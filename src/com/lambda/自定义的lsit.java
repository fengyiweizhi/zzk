package com.lambda;

/**
 * @author 风亦未止
 * @date 2022/11/5 15:55
 */
public class 自定义的lsit {


    public static void main(String[] args) {
        MyList<Person> list=new MyList<>();
        for (int i=0;i<5;i++){
            Person person = new Person("zzk"+i,1+i);
            list.add(person);
        }
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }

        //筛选zzk2的对象
        MyList<Person> filter = list.filter(a -> {
            return a.getName().contains("zzk2");
        });

        System.out.println(filter.size());
        for (int i=0;i<filter.size();i++){
            System.out.println(filter.get(i).toString());
        }

    }
    static class Person{
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

    static class MyList<T> {
        private T[] data;
        private Integer size;

        public MyList<T> filter(Myfilter<T> myfilter){
            MyList<T> res=new MyList();
            for (int i=0;i<size;i++){
                if(myfilter.filter(data[i])){
                    res.add(data[i]);
                }
            }
            return res;
        }

        public MyList() {
           this.data= (T[]) new Object[1];
           this.size=0;
        }

        public T get(Integer num){
            if(num>size)return null;
            return data[num];
        }

        public boolean add(Object o) {
            // 扩容
            reSize(size);
            size++;
            data[size-1] = (T) o;
            return true;
        }

        public boolean remove(Object index) {
            Integer i= (Integer) index;
            if(i>=size)return false;
            for(int j=i+1;j<size;j++){
                data[j-1]=data[j];
            }
            reSize(size--);
            return true;
        }

        public void reSize(Integer size){
            // 三种扩容方式
            if(size+1 > data.length){
                T[] temp = (T[])new Object[size*2];
                for(int i = size-1,in = 0;i>=in;i--){
                    temp[i] = data[i];
                }
                data = temp;
            }
            if(size<= data.length/4 && data.length/2!=0){
                T[] temp = (T[])new Object[data.length/2];
                for(int i = size-1,in = 0;i>=in;i--){
                    temp[i] = data[i];
                }
                data = temp;
            }
        }
        public int size(){
            return size;
        }
    }

    interface Myfilter<T>{
        boolean filter(T obj);
    }
}
