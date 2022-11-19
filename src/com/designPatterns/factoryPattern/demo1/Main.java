package com.designPatterns.factoryPattern.demo1;

import com.designPatterns.factoryPattern.demo1.factory.FactoryA;
import com.designPatterns.factoryPattern.demo1.factory.FactoryB;

/**
 * 工厂模式
 * 如果你不想让某个子系统与较大的那个对象之间形成强耦合，而是想运行时从许多子系统中进行挑选的话，那么工厂模式是一个理想的选择
 * 将new操作简单封装，遇到new的时候就应该考虑是否用工厂模式;
 * 需要依赖具体环境创建不同实例，这些实例都有相同的行为,这时候我们可以使用工厂模式，简化实现的过程，同时也可以减少每种对象所需的代码量，有利于消除对象间的耦合，提供更大的灵活性
 * @author 风亦未止
 * @date 2022/6/16 18:29
 */
public class Main {
    public static void main(String[] args) {
        FactoryA factoryA = new FactoryA();
        FactoryB factoryB = new FactoryB();
        factoryA.produceA().show();
        factoryA.produceB().show();
        factoryB.produceA().show();
        factoryB.produceB().show();
    }
}
