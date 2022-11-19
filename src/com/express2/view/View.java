package com.express2.view;

import com.express2.bean.Express;

import java.util.*;

/**
 * 视图
 * @author 风亦未止
 */
public class View {
    Scanner scanner;

    //欢迎
    public void welcome(){
        System.out.println("欢迎使用xxx快递管理系统");
    }
    public int menu(){
        System.out.print("请根据提示输入：1，管理员 2，用户 3，退出 :");
        scanner=new Scanner(System.in);
        int num;
        try {
            num = Integer.parseInt(scanner.nextLine());
            if (num<1||num>3){
                System.out.println("输入错误，请重新输入");
                return menu();
            }
            return num;
        } catch (NumberFormatException e) {
            System.out.println("请输入数字！");
            return menu();
        }
    }


    //用户
    public int userMenu(){
        System.out.println("用户：");
        System.out.print("请根据提示输入：1，取快递 2，返回 :");
        scanner=new Scanner(System.in);
        int num;
        try {
            num = Integer.parseInt(scanner.nextLine());
            if (num<1||num>2){
                System.out.println("输入错误，请重新输入");
                return userMenu();
            }
            return num;
        } catch (NumberFormatException e) {
            System.out.println("请输入数字！");
            return userMenu();
        }

    }


    //管理员
    public int adminMenu(){
        System.out.println("管理员：");
        System.out.print("请根据提示输入：1，快递录入 2，删除快递 3，修改快递 4，查看所有快递 5，返回 :");
        scanner=new Scanner(System.in);
        int num;
        try {
            num = Integer.parseInt(scanner.nextLine());
            if (num<1||num>5){
                System.out.println("输入错误，请重新输入");
                return adminMenu();
            }
            return num;
        } catch (NumberFormatException e) {
            System.out.println("请输入数字！");
            return adminMenu();
        }

    }
    //快递录入
    public Express add(){
        System.out.println("快递录入：");
        scanner=new Scanner(System.in);
        System.out.println("请输入快递单号。");
        String num=scanner.nextLine();
        System.out.println("请输入快递公司。");
        String company=scanner.nextLine();
        Express express = new Express();
        express.setNum(num);
        express.setCompany(company);
        return express;
    }
    //修改快递
    public Express upData(Express express){
        System.out.println("修改快递：");
        scanner=new Scanner(System.in);
        System.out.println("请输入新的快递公司");
        String newCompany=scanner.nextLine();
        System.out.println("请输入新的快递单号");
        String newNum=scanner.nextLine();
        express.setCompany(newCompany);
        express.setNum(newNum);
        return express;
    }

    //通过单号查找快递
    public String findByNums(){
        System.out.print("请输入快递单号:");
        scanner=new Scanner(System.in);
        String num=scanner.nextLine();
        return num;
    }

    //通过取件码查找快递
    public int findByCode(){
        System.out.print("请输入取件码:");
        scanner=new Scanner(System.in);
        int num=Integer.parseInt(scanner.nextLine());
        return num;
    }

    //打印查找的快递信息
    public void printlnExpress(Express express){
        System.out.println("快递公司："+express.getCompany()+"，快递单号："+express.getNum()+"，快递取件码："+express.getCode());
    }
    //删除快递
    public boolean delete(){
        System.out.print("是否删除快递？ 1，是 2，否 ：");
        scanner=new Scanner(System.in);
        try {
            int num=Integer.parseInt(scanner.nextLine());
            if (num==1){
                return true;
            }else if (num==2){
                return false;
            }else {
                System.out.println("输入错误！请重新输入！");
                return delete();
            }
        } catch (NumberFormatException e) {
            System.out.println("请输入数字！");
            return delete();
        }
    }
    //是否成功取出
    public void isSuccess(boolean is){
        if (is==true){
            System.out.println("取出成功！");
            return;
        }
        System.out.println("取出失败！");

    }
    //是否成功删除
    public void isDelete(boolean is){
        if (is==true){
            System.out.println("删除成功！");
            return;
        }
        System.out.println("删除失败！");

    }

    //是否成功修改
    public void isUpdate(boolean is){
        if (is==true){
            System.out.println("修改成功！");
            return;
        }
        System.out.println("修改失败！");

    }
    //是否成功录入
    public void isAdd(boolean is){
        if (is==true){
            System.out.println("录入成功！");
            return;
        }
        System.out.println("录入失败！");

    }
    //单号已存在
    public void numExist(){
        System.out.println("单号已存在，录入失败！");
    }
    //快递是否存在
    public boolean isExist(Express express){
        if (express==null){
            System.out.println("快递不存在！");
            return false;
        }
        return true;
    }

    //查看所有快递
    public void printAll(HashMap<Integer,Express> expresses){
        int num=0;
        System.out.println("*******************************所有快递*********************************");
        Collection<Express> value=expresses.values();//获取值（快递）
        Iterator<Express> iterator=value.iterator();//迭代器
        while (iterator.hasNext()){
            printlnExpress(iterator.next());
            num++;
        }
        if (num==0){
            System.out.println("暂无快递信息！");
        }
        System.out.println("***********************************************************************");
    }

}
