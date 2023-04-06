package com.example.suanfademo.day02;

/**
 * @className: CircleLinkedList
 * @description: 单向环形连边 --> 约瑟夫问题
 * @author: xufh
 * @date: 2022/8/1
 */
public class CircleLinkedList {
    /**
     * 创建一个first节点，当前没有编号(或者当前编号无效)
     */
    private Boy first = new Boy(-1);

    /**
     * 添加节点
     *
     * @param nums 表示一共要添加nums个节点
     */
    public void add(int nums) {
        if (nums < 1) {
            System.out.println("节点数不正确");
            return;
        }
        //创建一个辅助指针用于构建环形链表
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }

        }
    }

    /**
     * 遍历当前的环形链表
     */
    public void listBoy() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        //因为first不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.println("编号是：" + curBoy.getNo());
            if (curBoy.getNext() == first) {
                //说明遍历完了
                break;
            }
            //后移
            curBoy = curBoy.getNext();
        }
    }

    /**
     * 出圈
     *
     * @param startNo 表示从第几个节点开始数数
     * @param countNo 表示数几下
     * @param nums    表示最初的所有节点数
     */
    public void outCircle(int startNo, int countNo, int nums) {
        //做数据校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建一个辅助指针，帮助完成节点出圈
        Boy helper = first;
        //让辅助指针指向环形链表的最后一个节点
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (helper != first) {
            for (int i = 0; i < countNo - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这是first指向的节点就是要出圈的节点
            System.out.println("出圈的节点是：" + first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后的节点是" + first.getNo());
    }

}

































