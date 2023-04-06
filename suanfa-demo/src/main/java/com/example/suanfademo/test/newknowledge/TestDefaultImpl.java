package com.example.suanfademo.test.newknowledge;

import java.util.function.Consumer;

/**
 * @className: TestDefaultImpl
 * @description: TODO 类描述
 * @author: xufh
 * @date: 2022/8/10
 */
public class TestDefaultImpl implements TestDefault {
    @Override
    public int add(int x, int y) {
        return x+y;
    }

    @Override
    public int sub(int x, int y) {
        return y-x;
    }

    public static void main(String[] args) {
        TestDefault testDefault = new TestDefaultImpl();
        System.out.println(testDefault.add(1, 3));
        System.out.println("testDefault.sub(4,5) = " + testDefault.sub(4, 5));
        System.out.println("-------------------------------------------------------------------------");
        String str = " hello lambda";
        Consumer<String> consumer = s -> System.out.println(s+str);
        consumer.accept("1");
    }
}
