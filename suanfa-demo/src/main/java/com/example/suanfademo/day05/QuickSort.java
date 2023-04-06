package com.example.suanfademo.day05;

import org.springframework.util.StopWatch;

/**
 * @className: QiuckSort
 * @description: 快速排序法
 * @author: xufh
 * @date: 2022/8/12
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int)(Math.random()*80000000);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        quickSort1(arr,0,arr.length-1);

        stopWatch.stop();
        System.out.println("stopWatch.getTotalTimeSeconds() = " + stopWatch.getTotalTimeSeconds());
//        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        //假定标准值取数组中间的值
        int pivot = arr[(right+left)/2];

    }

    /**
     * @param a 待排序数组
     * @param l   数组的最左边的元素下标
     * @param r   数组最右边的元素下标
     */
    public static void quickSort1(int[] a, int l, int r) {

        if (l < r) {
            int i,j,x;

            i = l;
            j = r;
            x = a[i];
            while (i < j) {
                while(i < j && a[j] > x)
                    j--; // 从右向左找第一个小于x的数
                if(i < j)
                    a[i++] = a[j];
                while(i < j && a[i] < x)
                    i++; // 从左向右找第一个大于x的数
                if(i < j)
                    a[j--] = a[i];
            }
            a[i] = x;
            quickSort(a, l, i-1); /* 递归调用 */
            quickSort(a, i+1, r); /* 递归调用 */
        }
    }

}
