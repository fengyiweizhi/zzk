package com.zzk.demo2;

/**
 * 游戏
 * @author 风亦未止
 */
public class Demo2 {
    public static void main(String[] args) {
        Game game = new Game();
        game.show(game.introduce);
    }

}
class Game{
    String name = "战地";
    String type = "FPS射击游戏";
    int space = 60;
    int star = 5;
    String introduce = "这是一款以第一次世界大战为背景的第一人称射击游戏！";
    public void show(String s){
        System.out.println(s);
    }

}