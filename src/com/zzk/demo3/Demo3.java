package com.zzk.demo3;
import java.util.Scanner;

/**
 * 试题二
 * @author 风亦未止
 */
public class Demo3 {
    public static void main(String[] args) {
        int account=0;
        MyList myList = new MyList();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入你的操作：1,存数据 2,删除数据 3,查询数据 4,退出");
            int a=scanner.nextInt();
            if (a>5){
                System.out.println("输入有误，请重新输入！");
                continue;
            }
            if (a==1){
                System.out.println("请输入你要储存的一个数字");
                int data=scanner.nextInt();
                myList.add(data,account);
                account++;

            }else if(a==2){
                System.out.println("请输入要删除的数据的下标");
                int flag=scanner.nextInt();
                myList.remove(flag);
            }
            else if(a==3){
                System.out.println("请输入要查询的下标");
                int flag=scanner.nextInt();
                myList.get(flag);
            }
            else if(a==4){
                break;
            }

        }
    }
}

class MyList{
   private int[] nums =new int[1];
   //增
   public void add(int a,int account){
       try {
           nums[account]=a;
       } catch (Exception e) {
           nums=addArrayLength(nums);
           nums[account]=a;
       }
       //为0的数据全部放到后面
       for (int i=1;i<=nums.length-1;i++){
           for (int j=0;j<=nums.length-1-i;j++){
               if (nums[j]==0){
                   nums[j]=nums[j+1];
                   nums[j+1]=0;
               }
           }
       }
       System.out.println("储存成功！");
       System.out.print("当前数据：【");
       for (int i=0;i<=nums.length-1;i++){
           System.out.print(nums[i]+",");
       }
       System.out.println("】");
   }
   //动态扩容
    public int[] addArrayLength(int[] array){
       int[] newArray=new int[array.length+1];
       System.arraycopy(array,0,newArray,0,array.length);

        return newArray;
    }
   //删
    public void remove(int flag){
       //将要删除的数据变成0,放到后面
       nums[flag]=0;
       for (int i=1;i<=nums.length-1;i++){
           for (int j=0;j<=nums.length-1-i;j++){
               if (nums[j]==0){
                   nums[j]=nums[j+1];
                   nums[j+1]=0;
               }
           }
       }
        System.out.println("删除数据成功！");
        System.out.print("当前数据：【");
        for (int i=0;i<=nums.length-1;i++){
            System.out.print(nums[i]+",");
        }
        System.out.println("】");

    }
    //查
    public void get(int flag){
       int size=0;
       for (int a=0;a<=nums.length-1;a++){
           if (nums[a]!=0){
               size++;
           }
       }
        System.out.println("(数据的有效的长度为："+size+")");
       if (flag>nums.length){
           System.out.println("查询的数据不存在");
           return;
       }
        System.out.println("查询到的结果为："+nums[flag]);

    }
}