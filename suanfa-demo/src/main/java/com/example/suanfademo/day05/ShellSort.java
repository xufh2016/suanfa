package com.example.suanfademo.day05;

import org.springframework.util.StopWatch;

/**
 * @className: HillSort
 * @description: 希尔排序
 * @author: xufh
 * @date: 2022/8/11
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int)(Math.random()*80000000);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        shellSort(arr);

        stopWatch.stop();
        System.out.println("stopWatch.getTotalTimeSeconds() = " + stopWatch.getTotalTimeSeconds());
//        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }
}
