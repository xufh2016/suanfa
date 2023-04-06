package com.example.suanfademo.day05;

import java.util.Arrays;

/**
 * @className: InsertSort
 * @description: 插入排序
 * @author: xufh
 * @date: 2022/8/11
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 24, 130, 4};
        insertSort(arr);

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;
        //i=0时的项是已经排好序的元素，所以从第二项开始也就是下标=1
        for (int i = 0; i < length; i++) {
            //j 是已排好序的数组下标
            for (int j = i ; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
