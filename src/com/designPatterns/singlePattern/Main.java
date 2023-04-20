package com.designPatterns.singlePattern;

/**
 *  经常new的，可以使用
 * 单例模式,,,创建一个对象，全局使用
 * @author 风亦未止
 * @date 2022/6/16 18:15
 */
public class Main {
    public static void main(String[] args) {
        //查询地址是否一样
        GlobalObject globalObject = GlobalObject.getGlobalObject();
        System.out.println(globalObject.getPassword());
        GlobalObject globalObject1 = GlobalObject.getGlobalObject();
        System.out.println(globalObject1.getUsername());
    }
}
