package com.dai.algo.algorithm.game;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 杨辉三角
 *  1
 *  1   1
 *  1   2   1
 *  1   3   3   1
 *  1   4   6   4   1
 * @date 2023/7/5 21:30
 */
public class YanghuiTriangle {
    /**
     * @description: 获取第i行j列的元素
     * @param:  i 行
     * @param:  j 列
     * @return: int
     * @author daihongli
     * @date: 2023/7/5 21:32
     */
    private static int getElement(int i, int j) {
        if (i == j || j == 0) {
            return 1;
        }
        return getElement(i - 1, j - 1) + getElement(i - 1, j);
    }

    /**
     * @description: 备忘录方式，获取第i行j列的元素
     * @param:  i 行
     * @param:  j 列
     * @return: int
     * @author daihongli
     * @date: 2023/7/5 21:32
     */
    private static int getElementV2(int i, int j, int[][] catche) {
        if (i == j || j == 0) {
            return 1;
        }
        if (catche[i][j] != 0) {
            return catche[i][j];
        }
        catche[i - 1][j - 1] = getElementV2(i - 1, j - 1, catche);
        catche[i - 1][j] = getElementV2(i - 1, j, catche);
        return catche[i - 1][j - 1] + catche[i - 1][j];
    }

    /**
     * @description: 打印杨辉三角
     * @param: i 行
     * @param: j 列
     * @return: void
     * @author daihongli
     * @date: 2023/7/5 21:38
     */
    private static void printYanghui(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", getElement(i, j));
            }
            System.out.println();
        }
    }

    /**
     * @description: 打印杨辉三角, 升级款，备忘录方式，避免重复递归
     * @param: n
     * @return: void
     * @author daihongli
     * @date: 2023/7/5 22:02
     */
    private static void printYanghuiV2(int n) {
        int[][] catche = new int[n][]; // 杨辉三角存入该二维数组，j列随行数变化而变化
        for (int i = 0; i < n; i++) {
            catche[i] = new int[i + 1]; // 第0行就有1列，n行为n+1列
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", getElementV2(i, j, catche));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // System.out.println(getElement(4, 3));
        printYanghui(8);
        printYanghuiV2(8);
    }
}
