package com.zzk.demo2;

/**
 *  Employee 类测试
 * @author 风亦未止
 */
public class Demo3 {
    public static void main(String[] args) {
        Employee employee = new Employee("张三",10086,8000,0.12);
        employee.calculate();
    }
}
class Employee{
    private String name;
    private long phone;
    private double money;
    private double rate;

    //计算工资
    public void calculate(){
        double addMoney=money*rate;
        double money2=money+money*rate;
        System.out.println(name+"获得的额外工资为："+addMoney);
        System.out.println("后来的工资为："+money2);
    }

    public Employee(String name, long phone, double money, double rate) {
        this.name = name;
        this.phone = phone;
        this.money = money;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}