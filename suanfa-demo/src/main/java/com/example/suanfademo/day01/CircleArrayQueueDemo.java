package com.example.suanfademo.day01;

/**
 * @className: CircleArrayQueue
 * @description: 环形队列实现
 * @author: xufh
 * @date: 2022/7/21
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);//说明设置4，其队列的有效大小是3，因为有一个约定位
        circleArrayQueue.addQueue(1);
        circleArrayQueue.addQueue(12);
        circleArrayQueue.addQueue(13);
        circleArrayQueue.showQueue();
        System.out.println("circleArrayQueue.getQueue() = " + circleArrayQueue.getQueue());
        circleArrayQueue.showQueue();
        circleArrayQueue.addQueue(14);
        circleArrayQueue.showQueue();
    }
}

class CircleArrayQueue {
    //数组最大容量
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //该数组用于存放数据
    private int[] arr;

    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列
     *
     * @param n
     */
    public void addQueue(int n) {
        if (!isFull()) {
            arr[rear] = n;
            //将rear后移，必须考虑取模
            rear = (rear + 1) % maxSize;
        } else {
            throw new RuntimeException("队列已满~~~~~~~~~~");
        }
    }

    /**
     * 获取队列中的数据
     *
     * @return
     */
    public int getQueue() {
        if (!isEmpty()) {
            //这里需要分析出front是指向队列的第一个元素
            //1.先把front对应的值保留到一个临时变量
            //2. 将front后移,考虑取模
            //3.将临时变量返回
            int val = arr[front];
            front = (front + 1) % maxSize;
            return val;
        } else {
            throw new RuntimeException("队列为空，没有数据可取");
        }
    }

    /**
     * 打印
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
        }
        //思路：从front开始遍历，遍历多少个元素
        //思考
        for (int i = front; i < (front + this.size()); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 当前队列的有效个数
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 展示队列头的数据
     *
     * @return
     */
    public int displayHeader() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }
}