package com.zzk.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 出租车计费
 * @author 风亦未止
 */
public class Demo4 {
    private static boolean isStart=true;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (isStart){
            System.out.println("请输入你的里程。");
            int distance=scanner.nextInt();
            System.out.println("是否预约？输入y/n");
            String reserve=scanner.next();
            System.out.println("您是否提前4个小时预约？输入y/n");
            String reserve2=scanner.next();
            System.out.println("是否空驾驶？输入y/n");
            String freeDrive=scanner.next();
            System.out.println("请输入您出发的时间HH:mm");
            String sDate=scanner.next();
            System.out.println("请输入您到达时间HH:mm");
            String eDate=scanner.next();
            System.out.println("是否出现低速驾驶？输入y/n");
            String isLow=scanner.next();
            System.out.println("低速驾驶开始的时间？HH:mm(如果没有请输入1忽略)");
            String lowStart=scanner.next();
            System.out.println("低速驾驶结束的时间？HH:mm(如果没有请输入1忽略)");
            String lowEnd=scanner.next();
            double price1=mileagePrice(distance);
            double price2=reserveFee(reserve,reserve2);
            double price3=nightFee(sDate,eDate,distance);
            double price4=lowSpeedFee(isLow,lowStart,lowEnd);
            //如果price4或price3返回的结果为-1，表输入时间的格式错误，继续循环
            if (price4==-1||price3==-1){
                continue;
            }
            double price5=freeDriveFee(freeDrive,distance);
            double price6=fee();
            double sum=price1+price2+price3+price4+price5+price6;
            System.out.println("您出行的总费用为："+sum);
            isStart=false;
        }

    }
    //里程费用的计算
    public static double mileagePrice(int distance){
        double price=0;
        if (distance<3){
           price=13;
        }else {
            price=13+(distance-3)*2.3;
        }
        return price;
    }
    //低速行驶费的计算
    public static double lowSpeedFee(String is,String start,String end) {
        double price=0;
        if (is.equals("y")){
            Date startDate= null;
            Date endDate= null;
            long minuteTime= 0;
            Date s= null;
            Date e= null;
            Date s2= null;
            Date e2= null;
            try {
                //计算驾驶的时间
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                startDate = simpleDateFormat.parse(start);
                endDate = simpleDateFormat.parse(end);
                long time=(endDate.getTime()-startDate.getTime())/1000;
                minuteTime = time/60;
                //早晚高峰时间段
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm");
                s = simpleDateFormat2.parse("7:00");
                e = simpleDateFormat2.parse("9:00");
                s2 = simpleDateFormat2.parse("17:00");
                e2 = simpleDateFormat2.parse("19:00");
            } catch (ParseException parseException) {
                System.out.println("您输入的时间格式有误!请重新输入");
                return -1;
            }
            if ((startDate.after(s)&&endDate.before(e))||(startDate.after(s2)&&endDate.before(e2))){
                price=(minuteTime/5)*2.3*2;
            }else {
                price=(minuteTime/5)*2.3;
            }
        }
        return price;

    }

    //预约叫车服务费的计算
    public static double reserveFee(String y,String n){
        double price=0;
        if (y.equals("y")&&n.equals("y")){
            price=6;
        }else if (y.equals("y")&&n.equals("n")){
            price=4;
        }
        return price;
    }

    //空驶费的计算
    public static double freeDriveFee(String y,int distance){
        double price=0;
        if (y.equals("y")&&distance>15){
            price=(distance-15)*(2.3*0.5);
        }
        return price;
    }

    //夜间收费的计算
    public static double nightFee(String start,String end,int distance){
        double price=0;
        Date startDate = null;
        Date endDate = null;
        Date strat2 = null;
        Date midTime = null;
        Date end2 = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
            startDate = simpleDateFormat.parse(start);
            endDate = simpleDateFormat.parse(end);
            //夜间行驶的时间
            strat2 = simpleDateFormat.parse("23:00");
            midTime = simpleDateFormat.parse("00:00");
            end2 = simpleDateFormat.parse("5:00");
        } catch (ParseException e) {
            System.out.println("您输入的时间格式有误!请重新输入");
            return -1;
        }
        if ((startDate.after(strat2)&&endDate.before(midTime))||(startDate.after(midTime)&&endDate.before(end2))){
            price=(distance-3)*(2.3*0.2);
        }
        else if ((startDate.after(strat2)&&startDate.before(midTime))&&(endDate.after(midTime)&&endDate.before(end2))){
            price=(distance-3)*(2.3*0.2);
        }
        return price;
    }
    //燃油附加费
    public static double fee(){
        return 1;
    }
}
