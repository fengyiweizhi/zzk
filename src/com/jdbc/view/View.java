package com.jdbc.view;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.jdbc.bean.Flight;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 视图
 * @author 风亦未止
 */
public class View {
    //欢迎
    public void welcome(){
        System.out.println("***********************欢迎使用航班信息管理系统*********************");
    }
    //主菜单
    public int menu(){
        System.out.print("请选择操作（1.列出所有航班，2.按起飞的时间查询，3.按目的地查询，4.删除航班，5.更新航班，6.离开系统）：");
        Scanner scanner = new Scanner(System.in);
        int s = 0;
        try {
            s = scanner.nextInt();
            if (s<=0||s>6){
                System.out.println("输入错误！请重新输入!");
                return menu();
            }
        } catch (InputMismatchException e) {
            System.out.println("请输入数字！");
            return menu();
        }
        return s;
    }
    //按起飞时间查询
    public String findByTime(){
        System.out.print("请输入日期：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        return s;
    }
    //按目的地查询
    public String findByCity(){
        System.out.print("请输入目的地：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        return s;
    }
    //更新航班
    public Flight update(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入需要更新的编号：");
        int id = scanner.nextInt();
        System.out.print("请输入新的航班号：");
        String flightId = scanner.next();
        System.out.print("请输入新的目的地：");
        String city = scanner.next();
        System.out.print("请输入新的起飞日期：");
        String time = scanner.next();
        Flight flight = new Flight(id,flightId,city,time);
        return flight;
    }
    //删除航班
    public String delete(){
        System.out.print("请输入需要删除的航班号：");
        Scanner scanner = new Scanner(System.in);
        String i = scanner.next();
        return i;
    }
    //列出所有
    public void showAll(List<Flight> flights){
        System.out.println("编号\t"+"航班号\t"+"目的地\t"+"起飞时间");
        if (flights.size()>0){
            for (Flight f:flights) {
                show(f);
            }
        }else {
            System.out.println("暂时没有航班信息！");
        }
    }
    //列出航班
    public void show(Flight f){
        System.out.println(f.getId()+"\t    "+f.getFlightId()+"\t    "+f.getCity()+"\t    "+f.getTime());
    }
    public void deleteS(){
        System.out.println("删除成功！");
    }
    public void deleteF(){
        System.out.println("删除失败！");
    }
    public void updateS(){
        System.out.println("更新成功！");
    }
    public void updateF(){
        System.out.println("更新失败！");
    }
}
