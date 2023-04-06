package com.example.suanfademo.day05;

import org.springframework.util.StopWatch;

/**
 * @className: RadixSort
 * @description: 基数排序
 * @author: xufh
 * @date: 2022/8/16
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        radixSort(arr);
        stopWatch.stop();
        System.out.println("stopWatch.getTotalTimeSeconds() = " + stopWatch.getTotalTimeSeconds());
    }

    public static void radixSort(int[] arr) {
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //说明：
        //1. 二维数组包含10个一维数组
        //2. 为了防止在放入数的时候，数据移除，每个一维数组（桶）的长度取arr.length
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中，实际放了多少个数据，我们定义一个一维数组记录各个桶的每次放入的数据个数
        int[] bucketElementCount = new int[10];
        //得到数组中最大的数的位数
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();
        for (int k = 0; k < maxLength; k++) {
            for (int i = 0; i < arr.length; i++) {
                //取出每个元素的个位数
                int digitOfElement = arr[i] / (int) (Math.pow(10, k)) % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[i];
                bucketElementCount[digitOfElement]++;
            }
            //按照桶的顺序（一维数组的下标依次取出数据，放入原来数组）
            int index = 0;
            for (int i = 0; i < bucketElementCount.length; i++) {
                //如果桶中有数据，我们才放入原数组中
                if (bucketElementCount[i] != 0) {
                    //循环第i个桶
                    for (int j = 0; j < bucketElementCount[i]; j++) {
                        //取出元素放入到arr中
                        arr[index] = bucket[i][j];
                        index++;
                    }
                }
                //第一轮处理后，需要将每个bucketElementCount[i]置零
                bucketElementCount[i] = 0;
            }
        }
    }
}
