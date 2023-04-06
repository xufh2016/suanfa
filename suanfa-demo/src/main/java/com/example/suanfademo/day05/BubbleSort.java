package com.example.suanfademo.day05;

import org.springframework.util.StopWatch;

import java.util.Arrays;

/**
 * @className: BubbleSort
 * @description: 冒泡排序
 * @author: xufh
 * @date: 2022/8/9
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 12, -2};
//        int[] arr = new int[8000];
//        for (int i = 0; i < 8000; i++) {
//            arr[i] = (int) (Math.random() * 8000);
//        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int temp;
        for (int j = 0; j < arr.length - 1; j++) {
            //表示是否进行过交换，没有发生交换说明顺序是正确的
            boolean flag = false;
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            //优化排序
            if (!flag) {
                break;
            }
        }
        stopWatch.stop();
        System.out.println("stopWatch = " + stopWatch.getTotalTimeSeconds() );
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
}
