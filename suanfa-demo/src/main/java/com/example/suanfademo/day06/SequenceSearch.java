package com.example.suanfademo.day06;

/**
 * @className: SequenceSearch
 * @description: 线性查找
 * @author: xufh
 * @date: 2022/8/17
 */
public class SequenceSearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 11, 3, 10, 44, 72};
        int i = sequenceSearch(arr, 72);
        System.out.println("i = " + i);
    }

    /**
     *
     * @param arr  待查找数组
     * @param val  待查找的值
     */
    public static int sequenceSearch(int[] arr, int val) {
        for (int i = 0; i <= arr.length-1; i++) {
            if (arr[i] == val){
                return i;
            }
        }
        return -1;
    }
}
