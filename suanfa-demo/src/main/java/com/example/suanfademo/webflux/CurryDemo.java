package com.example.suanfademo.webflux;

import java.util.function.Function;

/**
 * @className: CurryDemo
 * @description: 级联表达式和柯里化
 * @author: xufh
 * @date: 2022/8/11
 */
public class CurryDemo {
    public static void main(String[] args) {
        Function<String, Function> function = s -> y -> s + y;
        String apply = (String) function.apply("a").apply("b");
        System.out.println("apply = " + apply);
        Function<Integer, Function<Integer, Function<Integer, Integer>>> function1 = x -> y -> z -> x + y + z;
        Integer apply1 = function1.apply(1).apply(3).apply(5);
        System.out.println("apply1 = " + apply1);
    }
}
