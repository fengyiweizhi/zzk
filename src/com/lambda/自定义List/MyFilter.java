package com.lambda.自定义List;

/**
 * @author 风亦未止
 * @date 2023/3/31 19:53
 */
public interface MyFilter<T> {
    boolean filter(T obj);
}
