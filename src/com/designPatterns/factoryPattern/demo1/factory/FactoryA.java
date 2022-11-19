package com.designPatterns.factoryPattern.demo1.factory;

import com.designPatterns.factoryPattern.demo1.product.Product;
import com.designPatterns.factoryPattern.demo1.product.ProductA_1;
import com.designPatterns.factoryPattern.demo1.product.ProductB_1;

/**
 * @author 风亦未止
 * @date 2022/6/16 18:50
 */
public class FactoryA extends Factory{
    @Override
    public Product produceA() {
        return new ProductA_1();
    }

    @Override
    public Product produceB() {
        return new ProductB_1();
    }
}
