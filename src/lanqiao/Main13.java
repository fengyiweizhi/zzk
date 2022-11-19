package lanqiao;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

/**
 * 回文本日期
 */
public class Main13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int i = scan.nextInt();
        while (i<Integer.MAX_VALUE){
            ++i;
            boolean isrever = isrever(i);
            if (isrever){
                break;
            }
        }
        System.out.println(i);
        if (isreverABAB(i)){
            System.out.println(i);
        }else {
            while (i<Integer.MAX_VALUE){
                ++i;
                boolean isrever = isreverABAB(i);
                if (isrever){
                    break;
                }
            }
            System.out.println(i);
        }
        scan.close();
    }

    public static boolean isrever(int num){
        int front1=num/10000000;
        int front2=(num/1000000)%(front1*10);
        int front3=(num/100000)%(front1*100+front2*10);
        int front4=(num/10000)%(front1*1000+front2*100+front3*10);

        int end1=num%10;
        int end2=num%100/10;
        int end3=num%1000/100;
        int end4=num%10000/1000;

        if (end1==front1&&front2==end2&&front3==end3&&front4==end4){
            int moth=end4*10+end3;
            int year=num/10000;
            int day=end2*10+end1;
            int realday=28;
            if (moth<=12&&moth>0){
                if (year%4==0){
                    switch (moth){
                        case 1:
                            realday=31;
                            break;
                        case 2:
                            realday=29;
                            break;
                        case 3:
                            realday=31;
                            break;
                        case 4:
                            realday=30;
                            break;
                        case 5:
                            realday=31;
                            break;
                        case 6:
                            realday=30;
                            break;
                        case 7:
                            realday=31;
                            break;
                        case 8:
                            realday=31;
                            break;
                        case 9:
                            realday=30;
                            break;
                        case 10:
                            realday=31;
                            break;
                        case 11:
                            realday=30;
                            break;
                        case 12:
                            realday=31;
                            break;
                    }
                }else {
                    switch (moth){
                        case 1:
                            realday=31;
                            break;
                        case 2:
                            realday=28;
                            break;
                        case 3:
                            realday=31;
                            break;
                        case 4:
                            realday=30;
                            break;
                        case 5:
                            realday=31;
                            break;
                        case 6:
                            realday=30;
                            break;
                        case 7:
                            realday=31;
                            break;
                        case 8:
                            realday=31;
                            break;
                        case 9:
                            realday=30;
                            break;
                        case 10:
                            realday=31;
                            break;
                        case 11:
                            realday=30;
                            break;
                        case 12:
                            realday=31;
                            break;
                    }
                }
                if (day<realday&&day>0){
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
    public static boolean isreverABAB(int num){
        int front1=num/10000000;
        int front2=(num/1000000)%(front1*10);
        int front3=(num/100000)%(front1*100+front2*10);
        int front4=(num/10000)%(front1*1000+front2*100+front3*10);

        int end1=num%10;
        int end2=num%100/10;
        int end3=num%1000/100;
        int end4=num%10000/1000;

        if (front1==front3&&front1==end1&&front1==end3&&front2==front4&&front2==end4&&front2==end2){
            int moth=end4*10+end3;
            int year=num/10000;
            int day=end2*10+end1;
            int realday=28;
            if (moth<=12&&moth>0){
                if (year%4==0){
                    switch (moth){
                        case 1:
                            realday=31;
                            break;
                        case 2:
                            realday=29;
                            break;
                        case 3:
                            realday=31;
                            break;
                        case 4:
                            realday=30;
                            break;
                        case 5:
                            realday=31;
                            break;
                        case 6:
                            realday=30;
                            break;
                        case 7:
                            realday=31;
                            break;
                        case 8:
                            realday=31;
                            break;
                        case 9:
                            realday=30;
                            break;
                        case 10:
                            realday=31;
                            break;
                        case 11:
                            realday=30;
                            break;
                        case 12:
                            realday=31;
                            break;
                    }
                }else {
                    switch (moth){
                        case 1:
                            realday=31;
                            break;
                        case 2:
                            realday=28;
                            break;
                        case 3:
                            realday=31;
                            break;
                        case 4:
                            realday=30;
                            break;
                        case 5:
                            realday=31;
                            break;
                        case 6:
                            realday=30;
                            break;
                        case 7:
                            realday=31;
                            break;
                        case 8:
                            realday=31;
                            break;
                        case 9:
                            realday=30;
                            break;
                        case 10:
                            realday=31;
                            break;
                        case 11:
                            realday=30;
                            break;
                        case 12:
                            realday=31;
                            break;
                    }
                }
                if (day<realday&&day>0){
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

}
