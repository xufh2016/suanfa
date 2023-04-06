package com.example.suanfademo.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: BinarySearch
 * @description: 二分查找法-使用二分查找，待查找线性数据结构必须有序
 * @author: xufh
 * @date: 2022/8/17
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 7, 11, 99, 1001,2989};
//        int i = binarySearch(arr, 6, 0, arr.length - 1);
//        System.out.println("i = " + i);
        List<Integer> integers = binarySearchMul(arr, 1001, 0, arr.length - 1);
        System.out.println("integers = " + integers);
    }

    /**
     * @param arr     带查找数组
     * @param findVal 带查找值
     * @param left    左边索引
     * @param right   右边索引
     * @return
     */
    public static int binarySearch(int[] arr, int findVal, int left, int right) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (left > right) {
            return -1;
        }
        if (findVal > midVal) {
            return binarySearch(arr, findVal, mid + 1, right);
        } else if (findVal < midVal) {
            return binarySearch(arr, findVal, left, mid - 1);
        } else {
            return mid;
        }
    }

    /**
     * @param arr     带查找数组
     * @param findVal 带查找值
     * @param left    左边索引
     * @param right   右边索引
     * @return
     */
    public static List<Integer> binarySearchMul(int[] arr, int findVal, int left, int right) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (left > right) {
            return null;
        }
        if (findVal > midVal) {
            return binarySearchMul(arr, findVal, mid + 1, right);
        } else if (findVal < midVal) {
            return binarySearchMul(arr, findVal, left, mid - 1);
        } else {
            List<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == findVal) {
                list.add(temp);
                temp--;
            }
            list.add(mid);
            temp = mid+1;
            while (temp <= arr.length - 1 && arr[temp] == findVal) {
                list.add(temp);
                temp++;
            }
            return list;
        }
    }
}
