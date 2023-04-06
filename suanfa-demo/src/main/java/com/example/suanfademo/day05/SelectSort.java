package com.example.suanfademo.day05;

import org.springframework.util.StopWatch;

/**
 * @className: SelectSort
 * @description: 选择排序
 * @author: xufh
 * @date: 2022/8/10
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int j = 0; j < arr.length; j++) {
            int min = arr[j];
            int minIndex = j;
            for (int i = j; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                    minIndex = i;
                }
            }
            //交换,当minIndex不等于当前项的时候才发生交换
            if (minIndex != j) {
                arr[minIndex] = arr[j];
                arr[j] = min;
            }
        }
        stopWatch.stop();
        System.out.println("stopWatch.getTotalTimeSeconds() = " + stopWatch.getTotalTimeSeconds());
    }
}
