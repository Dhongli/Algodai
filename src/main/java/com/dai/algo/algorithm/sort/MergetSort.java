package com.dai.algo.algorithm.sort;

import java.util.Arrays;

public class MergetSort {
    public static void main(String[] args) {
        int[] arr = {8, 7, 6, 5, 4, 3, 2, 1};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length -1, temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 向左递归进行分解
            mergeSort(arr, left, mid, temp);
            // 向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            // 分解一次合并一次
            merge(arr, left, right, mid, temp);
        }
    }

    /**
     * 合并的方法
     *
     * @param arr arr要排序的数组
     * @param left 最左边
     * @param right 最右边
     * @param mid 中间
     * @param temp 中间数组
     */
    public static void merge(int[] arr, int left, int right, int mid, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        // 先把左右两边(有序)数据按规则填充到temp数组
        // 直到左右两边有序序列,有一边处理完毕为止
        while (i <= mid && j <= right) {
            // 如果左边有序序列当前元素, 小于等于右边有序序列当前元素
            // if时把左边元素添加到temp中的t位置,i与t后移,else时则填加j,j与t后移
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        // 将有剩余数据的一边的数据依次全部填充到temp
        // 左边有序序列有剩余
        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        // 右边有序序列有剩余
        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        // 将temp拷贝到arr
        t = 0;
        int tempLeft = left;
        System.out.println("tempLeft=" + tempLeft + " right=" + right);
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
