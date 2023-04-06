package com.example.suanfademo.day06;

import java.util.Arrays;

/**
 * @className: FibonacciSearch
 * @description: TODO 类描述
 * @author: xufh
 * @date: 2022/8/19
 */
public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {

        int[] arr = {1, 7, 11, 99, 1001, 2989};
        System.out.println(fibonacciSearch(arr,1001));
    }

    /**
     * @param arr 待查找数组
     * @param key 我们需要查找的关键值
     * @return 下标
     */
    public static int fibonacciSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        //斐波那契分割数值的下标
        int fibK = 0;
        //用于存放mid值
        int mid = 0;
        //获取斐波那契数组
        int[] fibonaccis = fibonacci();
        //得到斐波那契数组下标
        while (high > fibonaccis[fibK] - 1) {
            fibK++;
        }
        // fibonaccis[fibK]值可能大于arr的长度，因此需要使用Arrays类，构造一个新的数组，并指向arr
        int[] temp = Arrays.copyOf(arr, fibonaccis[fibK]);
        //实际上需要使用arr数组最后的数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        //使用while循环处理查找我们的key
        while (low <= high) {
            mid = low + fibonaccis[fibK - 1] - 1;
            if (key < temp[mid]) {
                //左查找
                high = mid - 1;
                //
                fibK--;
            } else if (key > temp[mid]) {
                //右查找
                low = mid + 1;
                fibK -= 2;
            } else {
                return Math.min(mid, high);
            }
        }
        return -1;
    }


    public static int[] fibonacci() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
}
