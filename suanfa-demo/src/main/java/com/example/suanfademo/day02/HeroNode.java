package com.example.suanfademo.day02;

import lombok.Data;

/**
 * @className: HeroNode
 * @description: 单链表
 * @author: xufh
 * @date: 2022/7/27
 */
@Data
public class HeroNode {
    /**
     * 排名
     */
    int num;
    /**
     * 名字
     */
    String name;
    /**
     * 花名
     */
    String nickName;
    /**
     * 下一个节点
     */
    HeroNode next;
    /**
     * 指向前一个节点
     */
    HeroNode pre;

    HeroNode(int num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
