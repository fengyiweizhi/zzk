package com.designPatterns.factoryPattern.demo1.factory;

import com.designPatterns.factoryPattern.demo1.product.Product;

/**
 * @author 风亦未止
 * @date 2022/6/16 18:47
 */
public abstract class Factory {
    /**
     * 生产产品A
     * @return
     */
    public abstract Product produceA();

    /**
     * 生产产品B
     * @return
     */
    public abstract Product produceB();
}
