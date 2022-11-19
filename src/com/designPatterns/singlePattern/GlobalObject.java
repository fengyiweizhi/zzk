package com.designPatterns.singlePattern;

/**
 *
 * 这是一个全局对象，实现只加载一遍
 * @author 风亦未止
 * @date 2022/6/16 18:14
 */
public class GlobalObject {
    private String username="root";
    private String password="123456";


    //创建一个全局对象，开局即创建
    private static class Create{
        private static GlobalObject globalObject=new GlobalObject();
    }

    /**
     * 设计私有构造函数，防止别人new
     */
    private GlobalObject(){}

    public static GlobalObject getGlobalObject(){
        return Create.globalObject;
    }

}
