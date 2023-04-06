package com.example.suanfademo.day02;

/**
 * @className: SingleLinkedList
 * @description: 定义一个单项链表用来存储heronode
 * @author: xufh
 * @date: 2022/7/27
 */
public class SingleLinkedList {
    /**
     * 定义一个头节点，头结点不能动,不存放具体数据
     */
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * @return 返回有效节点的个数
     */
    public int length() {
        if (this.head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode curNode = this.head.next;
        while (curNode != null) {
            length++;
            curNode = curNode.next;
        }
        return length;
    }

    /**
     * 添加
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        //用于标识添加的编号是否存在，默认为false
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
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
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
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
     * @param num 1. head节点不能动，因此需要一个辅助节点，通过辅助节点找到待删除节点点前一个节点
     */
    public void delete(int num) {
        HeroNode temp = head;
        //用于标识是否已找到待删除节点的前一个节点
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //已找到链表的最后了
                break;
            }
            if (temp.next.num == num) {
                //找到了待删节点的前一个节点temp
                flag = true;
                break;
            }
            //后移
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到编号为" + num + "的英雄");
        }
    }

    /**
     * 将原来的单链表进行翻转
     *
     * @param
     * @return
     */
    public void reverse() {
        if (this.head.next == null || head.next.next == null) {
            return;
        }
        //辅助指针
        HeroNode cur = head.next;
        //指向当前节点的下一个节点
        HeroNode next;
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来节点，并放在新的链表reverseHead的最前端
        while (cur != null) {
            //先暂时保存当前节点的下一个节点，因为后面需要使用
            next = cur.next;
            //将cur的下一个节点指向新的链表的最前端
            cur.next = reverseHead.next;
            //将cur连接到新的链表上
            reverseHead.next = cur;
            //让cur后移一次
            cur= next;
        }
        //将head.next指向reverseHead.next,实现饭庄
        head.next = reverseHead.next;
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
