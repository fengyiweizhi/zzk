package com.zzk.demo;

/**
 * @author 风亦未止
 */
public class demo3 {
    public static void main(String[] args) {
        System.out.println("Hello Word");
        double b=12;
        double a=reserveFee("n","n");
        System.out.println(a);
    }
    public static double reserveFee(String y,String n){
        double price=0;
        if (y.equals("y")&&n.equals("y")){
            price=6;
        }else if (y.equals("y")&&n.equals("n")){
            price=4;
        }
        return price;
    }
}
