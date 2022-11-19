package com.zzk.demo3;

import java.util.Random;
import java.util.Scanner;

/**
 * 猜拳游戏
 * @author 风亦未止
 */
public class Demo {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
//游戏类
class Game{
    public void start(){
        int rounds;
        int round=1;
        int num;
        int nums;
        int userScore;
        int robotScore;
        String g;
        String g2;
        System.out.println("*******************猜拳游戏*****************");
        System.out.println("游戏规则：你可以定义游戏有任意个回合，游戏结束后积分高的一方获胜");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入玩家姓名");
        User user = new User(scanner.next());
        Robot robot = new Robot();
        System.out.println("请输入回合数。");
        try {
            rounds = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("输入有误,请重新输入");
            return;
        }
        System.out.println("玩家："+user.getName()+" "+"当前积分"+user.getScore());
        System.out.println(robot.getName()+"当前积分"+robot.getScore());
        System.out.println("**************游戏开始！*************");
        while (true){
            System.out.println("第"+round+"回合");
            System.out.println("1.剪刀 2.石头 3.布");
            num=scanner.nextInt();
            if (num>3){
                System.out.println("输入错误，请重新输入！");
                continue;
            }
            if (num==1){
                g="剪刀";
            }else if (num==2){
                g="石头";
            }else {
                g="布";
            }
            nums=new Random().nextInt(3)+1;
            if (nums==1){
                g2="剪刀";
            }else if (nums==2){
                g2="石头";
            }else {
                g2="布";
            }
            if (num==nums){
                System.out.println("双方都出了"+g+"，平局");
            }else {
                System.out.println(user.getName()+"出了"+g+" "+robot.getName()+"出了"+g2);
                if((num==1&&nums==2)||(num==2&&nums==3)||(num==3&&nums==1)){
                    System.out.println("本回合 "+robot.getName()+"获胜，获得5积分!");
                    robotScore=robot.getScore()+5;
                    robot.setScore(robotScore);
                } else {
                    System.out.println("本回合 "+user.getName()+"获胜，获得5积分!");
                    userScore=user.getScore()+5;
                    user.setScore(userScore);
                }
            }
            if (round>=rounds){
                break;
            }
            round++;
        }
        System.out.println("**************游戏结束！*************");
        System.out.println("最终积分："+user.getName()+":"+user.getScore()+"分，"+robot.getName()+":"+robot.getScore()+"分。");
        if (user.getScore()>robot.getScore()){
            System.out.println("玩家"+user.getName()+"获得最终的游戏胜利！");
        }else if (user.getScore()==robot.getScore()){
            System.out.println("最终双方打为平手");
        } else {
            System.out.println(robot.getName()+"获得最终的游戏胜利！");
        }
    }


}
//玩家类
class User{
   private String name;
   private int score = 0;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

//机器人类
class Robot{
    private String name = "机器人";
    private int score = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
