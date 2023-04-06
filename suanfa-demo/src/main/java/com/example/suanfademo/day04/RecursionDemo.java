package com.example.suanfademo.day04;

/**
 * @className: RecursionDemo
 * @description: TODO 类描述
 * @author: xufh
 * @date: 2022/8/4
 */
public class RecursionDemo {
    public static void main(String[] args) {
        test(4);
        System.out.println("args = " + args);
    }

    private static void test(int i) {
        if (i > 2) {
            test(i - 1);
        }
        System.out.println("i-------------------------" + i);
    }
}
