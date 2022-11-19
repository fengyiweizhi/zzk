package com.javaEx;

/**
 * @author 风亦未止
 * @date 2022/6/29 15:25
 */
public class Stu {
    public static void main(String[] args) {
        stu zzk = new stu(1, "zzk");
        zzk.show();
    }
    static class stu{
        int sno;
        String name;
        public stu(int sno,String name){
            this.sno=sno;
            this.name=name;
        }
        public void show(){
            System.out.println("Sno is "+sno+"，Sname is "+name);
        }
    }
}
