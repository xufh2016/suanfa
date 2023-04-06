package com.example.suanfademo.day02;

/**
 * @className: DoubleLinkedList
 * @description: TODO 类描述
 * @author: xufh
 * @date: 2022/8/1
 */
public class DoubleLinkedList {
    /**
     * 定义一个头节点，头结点不能动,不存放具体数据
     */
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加节点到链表的最后
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        //构成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * 修改节点信息，根据num编号来修改，即num不能改
     */
    public void update(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表为空~~");
            return;
        }
        //找到需要修改的节点，根据num
        HeroNode temp = head.next;
        //表示是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                //说明temp就是链表最后了，已经遍历完了，因为temp是指向当前节点的下一个节点
                break;
            }
            if (temp.num == heroNode.num) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到了要修改的节点
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.println("没有找到编号是" + heroNode.num + "的信息");
        }
    }

    /**
     * 删除某个节点的信息
     *
     * @param num 对于双向链表，可以直接知道要删除的节点
     */
    public void delete(int num) {
        if (head.next == null) {
            System.out.println("空链表");
            return;
        }
        HeroNode temp = head.next;
        //用于标识是否已找到待删除节点的前一个节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                //已找到链表的最后了
                break;
            }
            if (temp.num == num) {
                //找到了待删节点的前一个节点temp
                flag = true;
                break;
            }
            //后移
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("没有找到编号为" + num + "的英雄");
        }
    }

    /**
     * 按顺序添加
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head.next;
        //用于标识添加的编号是否存在，默认为false
        boolean flag = false;
        while (true) {
            if (temp == null) {
                System.out.println("已到链表末尾");
                break;
            }
            //位置找到，就在temp的后面插入
            if (temp.next.num > heroNode.num) {
                break;
            } else if (temp.next.num == heroNode.num) {
                //判断编号是否已存在
                flag = true;
                break;
            }
            //后移
            temp = temp.next;
        }
        //判断flag的值
        if (flag) {
            //不能添加，编号已存在
            System.out.println("出场英雄" + heroNode.num + ":::" + heroNode.nickName + "已被选择，不能再出场了。。。");
        } else {
            //插入到链表中,temp的后面
            assert temp != null;
            heroNode.next = temp.next;
            temp.next.pre = heroNode;
            temp.next = heroNode;
            heroNode.pre = temp;
        }
    }

    /**
     * 显示
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (temp != null) {
            //是否到链表最后
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
