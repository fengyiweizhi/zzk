package com.zzk.demo2;

/**
 * 自增衣服
 * @author 风亦未止
 */
public class Demo6 {
    public static void main(String[] args) {
        Clothes clothes1 = new Clothes("外套1", 1000);
        Clothes clothes2 = new Clothes("外套2", 2000);
        Clothes clothes3 = new Clothes("外套3", 3000);
        System.out.println(clothes1.getType()+"的序号为："+clothes1.getNumber()+"，价格为："+clothes1.getPrice());
        System.out.println(clothes2.getType()+"的序号为："+clothes2.getNumber()+"，价格为："+clothes2.getPrice());
        System.out.println(clothes3.getType()+"的序号为："+clothes3.getNumber()+"，价格为："+clothes3.getPrice());

    }
}
class Clothes{
   private String type;
   private int price;
   private int number;
   static int count;

    public Clothes(String type, int price) {
        this.type = type;
        this.price = price;
        //生成自增序号，并储存
        count++;
        this.number=count;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}