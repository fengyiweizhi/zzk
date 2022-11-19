package com.javaEx;

/**
 * @author 风亦未止
 * @date 2022/6/29 15:18
 */
public class MyDemo {
    public static void main(String[] args) {
        Area area = new Area();
        System.out.println(area.getArea(5));
    }
    static class Area{
        final double pi=3.14;
        public double getArea(int r){
            return pi*r*r;
        }
    }
}
