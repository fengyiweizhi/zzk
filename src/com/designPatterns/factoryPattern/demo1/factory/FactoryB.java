package com.designPatterns.factoryPattern.demo1.factory;

import com.designPatterns.factoryPattern.demo1.product.Product;
import com.designPatterns.factoryPattern.demo1.product.ProductA_2;
import com.designPatterns.factoryPattern.demo1.product.ProductB_2;

/**
 * @author 风亦未止
 * @date 2022/6/16 18:50
 */
public class FactoryB extends Factory{
    @Override
    public Product produceA() {
        return new ProductA_2();
    }

    @Override
    public Product produceB() {
        return new ProductB_2();
    }
}
