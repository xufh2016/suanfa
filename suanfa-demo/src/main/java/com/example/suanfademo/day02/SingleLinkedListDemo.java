package com.example.suanfademo.day02;

/**
 * @className: SingleLinkedList
 * @description: TODO 类描述
 * @author: xufh
 * @date: 2022/7/27
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "林冲", "豹子头");
        HeroNode heroNode2 = new HeroNode(3, "鲁智深", "花和尚");
        HeroNode heroNode3 = new HeroNode(2 , "松江", "及时雨");
        HeroNode heroNode4 = new HeroNode(5, "武松", "行者");
        HeroNode heroNode5 = new HeroNode(4, "H20", "水分子");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);
        System.out.println("---------------------原数据-------------------");
        doubleLinkedList.list();
        System.out.println("---------------------按顺序添加-------------------");
        doubleLinkedList.addByOrder(heroNode5);
        doubleLinkedList.list();
//        System.out.println("---------------------更新后-------------------");
//        doubleLinkedList.update(heroNode5);
//        doubleLinkedList.list();
//        System.out.println("---------------------删除后-------------------");
//        doubleLinkedList.delete(2);
//        doubleLinkedList.list();
//        System.out.println("当前有效个数是：" + singleLinkedList.length());
    }
}
