package com.dai.algo.algorithm.erchashu;

/**
 * 斐波那契数列,后面的数是前面两个数的和
 */
public class Fibna {
    public static void main(String[] args) {
        System.out.println(getFib(6));
    }
    // 1,1,2,3,5 时间复杂度O(n),空间复杂度O(1)
    private static int getFib(int n) {
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
}
