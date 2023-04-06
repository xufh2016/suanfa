package com.example.suanfademo.day04;

/**
 * @className: Queen
 * @description: 八皇后问题
 * @author: xufh
 * @date: 2022/8/8
 */
public class Queen {
    /**
     * 表示共有多少个皇后
     */
    int max = 8;
    /**
     * 用于保存皇后放置位置的结果，比如arr[8]={0,4,7,5,2,6,1,3}
     */
    int[] arr = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.check(0);
        System.out.println("count = " + count);
    }

    /**
     * 放置第n个皇后
     *
     * @param n
     */
    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n放到该行的第1列
            arr[n] = i;
            //判断当放置第n个皇后在第i列时是否冲突
            if (judge(n)) {
                check(n + 1);
            }
            //如果冲突，就继续执行arr[n] = i;即将第n个皇后放置在本行的后移的一个位置
        }
    }


    /**
     * 查看当我们放置第n个皇后，就去检测该皇后是否和前面已摆放好的皇后冲突
     *
     * @param n 表示放第n个皇后
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //同一行、同一列的判断.arr[i] == arr[n]表示第n个皇后是否和前面的n-1个皇后是不是在同一列
            //Math.abs(n-i)==Math.abs(arr[n]-arr[i])表示判断第n个皇后是否和第i个皇后是否在同一斜线
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 写一个方法，可以将皇后摆放的位置打印出来
     */
    private void print() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
