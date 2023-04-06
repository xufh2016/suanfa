package com.example.suanfademo.day01;

/**
 * @className: SparseArray
 * @description: 稀疏数组
 * @author: xufh
 * @date: 2022/7/21
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0:表示没有棋子；1：表示黑色棋子；2：表示白色棋子
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[5][4] = 2;
        //输出原始棋盘中的棋子分布
        System.out.println("原始的数组：");
        for (int[] chess : chessArray) {
            for (int i : chess) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
        //将原始数组转为稀疏数组，
        //1、先遍历二维数组中有棋子的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        //2 创建对应的稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //遍历原来的二维数组，将非0值存放到稀疏数组中
        //用于记录是第几个非0数据
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
            }
        }
        System.out.println("稀疏数组：");
        for (int[] chess : sparseArray) {
            for (int i : chess) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
        System.out.println("再由稀疏数组转为原始数组：");
        int[][] chessArr = new int[sparseArray[0][0]][sparseArray[0][1]];
        //从稀疏数组的第二行开始遍历
        for (int i = 1; i < sparseArray.length; i++) {
            chessArr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        for (int[] chess : chessArr) {
            for (int i : chess) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }
}
