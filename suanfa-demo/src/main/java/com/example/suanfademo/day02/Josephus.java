package com.example.suanfademo.day02;

/**
 * @className: Josephus
 * @description: 约瑟夫问题----单向环形链表
 * @author: xufh
 * @date: 2022/8/2
 */
public class Josephus {
    public static void main(String[] args) {
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.add(5);
        circleLinkedList.listBoy();
        System.out.println("-------------------节点出圈------------------");
        circleLinkedList.outCircle(1,2,5);
    }
}
