package com.example.suanfademo.day07;

import lombok.Data;

/**
 * @className: HeroNode
 * @description:
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
     * 左边节点
     */
    HeroNode leftNode;
    /**
     * 右边节点
     */
    HeroNode rightNode;

    public HeroNode(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.leftNode != null) {
            this.leftNode.preOrder();
        }
        if (this.rightNode != null) {
            this.rightNode.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.leftNode != null) {
            this.leftNode.infixOrder();
        }
        System.out.println(this);
        if (this.rightNode != null) {
            this.rightNode.infixOrder();
        }
    }

    /**
     * 后续遍历
     */
    public void suffixOrder() {
        if (this.leftNode != null) {
            this.leftNode.suffixOrder();
        }
        if (this.rightNode != null) {
            this.rightNode.suffixOrder();
        }
        System.out.println(this);
    }

    /**
     * 前序遍历查找
     *
     * @param num 带查找的编号
     * @return
     */
    public HeroNode preOrderSearch(int num) {
        if (this.num == num) {
            return this;
        }
        HeroNode resNode = null;
        if (this.leftNode != null) {
            resNode = this.leftNode.preOrderSearch(num);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.rightNode != null) {
            resNode = this.rightNode.preOrderSearch(num);
        }
        return resNode;
    }

}
