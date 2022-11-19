package com.test.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo1 {
    public static void main(String[] args) throws ParseException {
        double a=lowSpeedFee("y","1","1");
        System.out.println(a);
    }
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
                System.out.println("请输入正确的时间");
            }
            if ((startDate.after(s)&&endDate.before(e))||(startDate.after(s2)&&endDate.before(e2))){
                price=(minuteTime/5)*2.3*2;
            }else {
                price=(minuteTime/5)*2.3;
            }
        }
        return price;

    }

}
