package com.dai.algo.algorithm.erchashu;

import java.util.Arrays;

/**
 * 斐波那契数列,后面的数是前面两个数的和
 */
public class Fibna {
    public static void main(String[] args) {
        System.out.println(getFib(6));
    }
    // 1,1,2,3,5 时间复杂度O(n),空间复杂度O(1)
    
    /** 
     * @description: 斐波那契数列非递归实现 
     * @param: n 
     * @return: int 
     * @author daihongli
     * @date: 2023/7/4 22:40
     */
    public static int getFib(int n) {
        if (n <=2) {
            return 1;
        }
        int a = 1, b = 1, c = 0;
        for (int i = 3;i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * @description: 斐波那契数列非递归实现 时间复杂度 1.6 * 2^n
     * @param: n
     * @return: int
     * @author daihongli
     * @date: 2023/7/4 22:45
     */
    public static int getFibDigui(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int a = getFibDigui(n - 1);
        int b = getFibDigui(n - 2);
        return a + b;
    }


    /**
     * @description: 备忘录法，斐波那契数列非递归实现优化版 时间复杂度 n
     * @param: n
     * @return: int
     * @author daihongli
     * @date: 2023/7/4 22:46
     */
    public static int getFibDiguiV2(int n) {
        int[] catche = new int[n];   // 保存前n项每项的值
        Arrays.fill(catche, -1); // 数组初始值填充为-1
        catche[0] = 1;
        catche[1] = 1;
        return getFibCatch(n, catche);
    }

    /**
     * @description: 缓存中具体项有值 则直接从缓存中取，不再继续深入
     * @param: n
     * @param: catche
     * @return: int
     * @author daihongli
     * @date: 2023/7/4 23:00
     */
    private static int getFibCatch(int n, int[] catche) {
        if (catche[n] != -1) {
            return catche[n];
        }
        catche[n - 1] = getFibDigui(n - 1);
        catche[n - 2] = getFibDigui(n - 2);
        return catche[n - 1] + catche[n - 2];
    }
}
