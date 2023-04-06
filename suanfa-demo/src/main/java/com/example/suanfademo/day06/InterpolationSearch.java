package com.example.suanfademo.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: InterpolationSearch
 * @description: 插值查找
 * @author: xufh
 * @date: 2022/8/18
 */
public class InterpolationSearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140};
        List<Integer> search = interpolationSearch(arr, 20, 0, arr.length - 1);
        System.out.println("search = " + search);
    }

    /**
     * @param arr     待查找数组
     * @param findVal 待查找值
     * @param left    数组最左边索引
     * @param right   数组最右边的下标
     * @return
     */
    public static List<Integer> interpolationSearch(int[] arr, int findVal, int left, int right) {
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (left > right) {
            return null;
        }
        if (findVal > midVal) {
            return interpolationSearch(arr, findVal, mid + 1, right);
        } else if (findVal < midVal) {
            return interpolationSearch(arr, findVal, left, mid - 1);
        } else {
            List<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == findVal) {
                list.add(temp);
                temp--;
            }
            list.add(mid);
            temp = mid + 1;
            while (temp <= arr.length - 1 && arr[temp] == findVal) {
                list.add(temp);
                temp++;
            }
            return list;
        }
    }
}
