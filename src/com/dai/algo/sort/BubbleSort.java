package com.dai.algo.sort;

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

    private static void bubbleSort(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j) > list.get(j - 1)) {
                    Collections.swap(list, j, j - 1);
                }
            }
        }
    }
}
