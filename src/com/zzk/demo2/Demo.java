package com.zzk.demo2;

/**
 * 汽车
 * @author 风亦未止
 */
public class Demo {
    public static void main(String[] args) {
        Car car = new Car();
        car.color = "绿色";
        car.brand = "奔驰";
        car.show();

    }
}
class Car{
    String brand;
    String color;
    public void show(){
        System.out.println("品牌："+brand+" "+"颜色:"+color);
    }
}
