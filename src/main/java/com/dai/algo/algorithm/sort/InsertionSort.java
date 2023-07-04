package com.dai.algo.algorithm.sort;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 快速排序
 * @date 2023/7/4 20:34
 */
public class InsertionSort {
    public static void sort(int[] a) {
        insertion(a, 1);
    }

    /**
     * @description: 插入排序递归实现
     * @param: a
     * @param: low 未排序的左边界，从1位置开始每递归一次加1
     * @return: void
     * @author daihongli
     * @date: 2023/7/4 21:31
     */
    private static void insertion(int[] a, int low) {
        if (low == a.length) return;
        int i = low - 1;    // i 为已排序的右边界
        int t = a[low];
        while (i >= 0 && a[i] > t) {
            a[i + 1] = a[i];
            i--;
        }
        a[i + 1] = t;
        insertion(a, low + 1);
    }

}
