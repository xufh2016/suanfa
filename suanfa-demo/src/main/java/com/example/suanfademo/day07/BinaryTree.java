package com.example.suanfademo.day07;

/**
 * @className: Tree
 * @description: 二叉树
 * @author: xufh
 * @date: 2022/9/5
 */
public class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("binary tree is null");
        }
    }

    /**
     * 中序
     */
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("binary tree is null");
        }
    }

    /**
     * 后序
     */
    public void suffixOrder() {
        if (this.root != null) {
            this.root.suffixOrder();
        } else {
            System.out.println("binary tree is null");
        }
    }


}
