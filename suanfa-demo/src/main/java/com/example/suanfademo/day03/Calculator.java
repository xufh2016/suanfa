package com.example.suanfademo.day03;

/**
 * @className: Calculator
 * @description:
 * @author: xufh
 * @date: 2022/8/3
 */
public class Calculator {
    public static void main(String[] args) {
        String exp = "3+2*5-2*8";
        //创建两个栈，数栈和操作符栈
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        //定义一个用于扫描的变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        //用于处理多位数
        StringBuilder temp = new StringBuilder();
        do {
            ch = exp.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {
                if (!operStack.isEmpty()) {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else {
//                 * 当处理多位数时，不能发现是一个数就立即入栈，因为可能是多位数。
//                 * 在入栈前需要向表达式的后面index再看一位，如果是数就继续扫描不能马上入栈，如果是符号再入栈
//                 * 因此需要定义一个变量用于拼接

                temp.append(ch);
                if (index == exp.length() - 1) {
                    numStack.push(Integer.parseInt(temp.toString()));
                } else {
                    //判断下一个字符是不是数字
                    if (operStack.isOper(exp.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(temp.toString()));
                        temp = new StringBuilder();
                    }
                }
            }
            index++;
        } while (index < (exp.length()));
        while (!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println("最终结果是~~~~~~~~~~~~~~~~~~~~~~:" + numStack.pop());
    }
}
