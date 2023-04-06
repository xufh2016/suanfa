package com.example.suanfademo.day05;

import org.springframework.util.StopWatch;

/**
 * @className: MergeSort
 * @description: 归并排序
 * @author: xufh
 * @date: 2022/8/15
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int)(Math.random()*80000000);
        }
//        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
//        System.out.println(Arrays.toString(arr));
        stopWatch.stop();
        System.out.println("stopWatch.getTotalTimeSeconds() = " + stopWatch.getTotalTimeSeconds());
    }

    /**
     * 分+和的过程
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并的过程（当合并的时候，被分解的数组已经是排好序的了）
     * 例如
     * @param arr   待排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //左边有序序列的初始索引
        int i = left;
        //右边有序序列的初始索引
        int j = mid + 1;
        //指向temp数组的当前索引
        int t = 0;
        //1、
        //先把左右两边(有序)的数组按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                //复制元素
                temp[t] = arr[i];
                //下面两行代码表示移动数组下标
                t += 1;
                i += 1;
            } else {
                //反之将右边有序序列的当前元素拷贝到temp数组中
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        //2、
        //把有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid) {
            //左边的有序序列还有剩余
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {
            //左边的有序序列还有剩余
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        //3、
        //将temp数组的元素拷贝到arr中
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
