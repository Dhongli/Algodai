package com.dai.algo.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 冒泡排序
 * 将输入的数由大到小排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (in.hasNextInt()) {
            int n = in.nextInt();
            list.add(n);
        }
        System.out.println(list);
        bubbleSort(list);
        System.out.println("排序后" + list);
    }

    /**
     * @description: 非递归实现
     * @param: list
     * @return: void
     * @author daihongli
     * @date: 2023/7/4 16:18
     */
    private static void bubbleSort(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j) > list.get(j - 1)) {
                    Collections.swap(list, j, j - 1);
                }
            }
        }
    }

    /**
     * @description: 冒泡递归实现
     * @param: arr
     * @return: void
     * @author daihongli
     * @date: 2023/7/4 17:20
     */
    public static void bubbleSortDigui(int[] arr) {
        // sort(arr, arr.length - 1);
        sortV2(arr, arr.length - 1);
    }

    /**
     * @description: 冒泡递归实现1版本
     * @param: arr
     * @return: void
     * @author daihongli
     * @date: 2023/7/4 17:20
     */
    private static void sort(int[] arr, int j) {
        if (0 == j) {
            return;
        }
        for (int i = 0; i < j; i++) {
            if (arr[i] > arr[i + 1]) {
                int s = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = s;
            }
        }
        sort(arr, j -1);
    }

    /**
     * @description: 冒泡递归实现2版本, x为最后交换位置，说明x后的都有序，不必每次j - 1
     * @param: arr
     * @return: void
     * @author daihongli
     * @date: 2023/7/4 17:20
     */
    private static void sortV2(int[] arr, int j) {
        if (0 == j) {
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (arr[i] > arr[i + 1]) {
                int s = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = s;
                x = i;
            }
        }
        sort(arr, x);
    }
}
