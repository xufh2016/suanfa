package com.example.suanfademo.day04;

/**
 * @className: Maze
 * @description: 迷宫游戏---递归实现
 * @author: xufh
 * @date: 2022/8/5
 */
public class Maze {
    public static void main(String[] args) {
        //创建一个二维数组来模拟迷宫
        int[][] map = new int[8][7];
        //使用1表示墙
        //初始化上下墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //初始化左右墙
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        setWay(map,1,1);
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 说明：i j表示小球的出发点。小球到map[6][5]表示通路找到。
     * 约定：当地图的i j为0时表示该点没有走过，当为1时表示墙；当为2时，表示一个通路可以走；当为3时表示该点已走过了，但路径不通
     * 在走迷宫时，需要确定一个策略 先：下->右->上->左 ，如果该点不通再回溯
     * <p>
     * 使用递归回溯来给小球找路
     *
     * @param map 地图
     * @param i   起始位置 x轴
     * @param j   起始位置 y轴
     * @return 找到通路返回true；否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            //当前点还没有走过
            if (map[i][j] == 0) {
                map[i][j] = 2;
                //向下走
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
