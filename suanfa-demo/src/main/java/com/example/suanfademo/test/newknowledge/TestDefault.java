package com.example.suanfademo.test.newknowledge;

/**
 * @className: TestDefault
 * @description: TODO 类描述
 * @author: xufh
 * @date: 2022/8/10
 */
public interface TestDefault {
    int add(int x,int y);
    default int sub(int x,int y){
        return x-y;
    }
}
