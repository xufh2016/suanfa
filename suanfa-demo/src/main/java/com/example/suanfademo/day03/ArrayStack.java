package com.example.suanfademo.day03;

/**
 * @className: ArrayStack
 * @description: 定义数组栈
 * @author: xufh
 * @date: 2022/8/3
 */
public class ArrayStack {
    /**
     * 栈大小
     */
    private int maxSize;
    /**
     * 数组，数组模拟栈，数据就放在数组中
     */
    private int[] stack;
    /**
     * 表示栈顶
     */
    private int top = -1;

    /**
     * 初始化栈
     *
     * @param maxSize
     */
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 判断栈满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 判断空栈
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     *
     * @param data
     */
    public void push(int data) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = data;
    }

    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            throw new RuntimeException("stack is empty");
        }
        int data = stack[top];
        top--;
        return data;
    }

    /**
     * 遍历栈，从栈顶开始
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            throw new RuntimeException("stack is empty");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("stack[" + i + "]" + "--------" + stack[i]);
        }
    }

    /**
     * 返回运算符的优先级，优先级是程序员来确定的，优先级使用数字表示
     * 数字越大，则优先级越高
     *
     * @param oper
     * @return
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断是不是运算符
     *
     * @param val
     * @return
     */
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算方法
     *
     * @param num1 栈中第一个弹出来的数
     * @param num2 栈中第二个弹出来的数
     * @param oper
     * @return
     */
    public int cal(int num1, int num2, int oper) {
        int result = 0;
        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 获得栈中数据的有效长度
     *
     * @return
     */
    public int effectiveLength() {
        return top + 1;
    }

    /**
     * 返回栈顶的值，只是一瞥，不是出栈
     * @return
     */
    public int peek(){
        return stack[top];
    }


}
