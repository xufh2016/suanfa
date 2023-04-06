package com.example.suanfademo.day07;

/**
 * @className: BinaryTreeDemo
 * @description: TODO 类描述
 * @author: xufh
 * @date: 2022/9/30
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1, "songjiang");
        HeroNode wuyong = new HeroNode(2, "wuyong");
        HeroNode lujunyi = new HeroNode(3, "lujunyi");
        HeroNode linchong = new HeroNode(4, "linchong");
        root.setLeftNode(wuyong);
        root.setRightNode(lujunyi);
        lujunyi.setLeftNode(linchong);
        binaryTree.setRoot(root);
        binaryTree.infixOrder();
    }
}
