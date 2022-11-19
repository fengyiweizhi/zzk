package com.zzk.demo3;

/**
 * 试题一
 * @author 风亦未止
 */
public class Demo2 {
    public static void main(String[] args) {
        User1 user1 = new User1();
        user1.login("admin",123);
    }

}
//用户类
class User1 extends UserService{
    private String name="用户1";

    @Override
    void login(String account, int passWord) {
        System.out.println(name+"正在登陆");
    }
}
//UserService类
abstract class UserService{
    abstract void login(String account,int passWord);
}
