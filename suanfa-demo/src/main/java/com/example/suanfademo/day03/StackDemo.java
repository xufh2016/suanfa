package com.example.suanfademo.day03;

/**
 * @className: StackDemo
 * @description: TODO 类描述
 * @author: xufh
 * @date: 2022/8/3
 */
public class StackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(5);
        arrayStack.push(8);
        arrayStack.push(12);
        arrayStack.push(3);
//        arrayStack.push(9);
//        arrayStack.push(11);
//        arrayStack.push(22);
        arrayStack.display();
        System.out.println("arrayStack.pop() = " + arrayStack.pop());
        arrayStack.display();
    }
}
