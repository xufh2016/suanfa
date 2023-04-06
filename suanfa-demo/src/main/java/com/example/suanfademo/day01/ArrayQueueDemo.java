package com.example.suanfademo.day01;

/**
 * @className: ArrayQueueDemo
 * @description: 数组模拟队列实现
 * @author: xufh
 * @date: 2022/7/21
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(10);
        arrayQueue.addQueue(11);

        System.out.println("arrayQueue.getQueue() = " + arrayQueue.getQueue());
        System.out.println("arrayQueue.getQueue() = " + arrayQueue.getQueue());
        arrayQueue.addQueue(13);
        System.out.println("arrayQueue.displayHeader() = " + arrayQueue.displayHeader());
        arrayQueue.showQueue();
    }
}

//使用数组模拟队列-编写一个叫ArrayQueue的队列
class ArrayQueue {
    //数组最大容量
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //该数组用于存放数据
    private int[] arr;

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        //指向队列头部，分析出front是指向队列头的前一个位置。
        front = -1;
        //指向队列尾部，直接指向队列尾的具体数据（包含队列尾）
        rear = -1;
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
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
            rear++;
            arr[rear] = n;
        }else {
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
            front++;
            return arr[front];
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
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
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
        return arr[front + 1];
    }

}
