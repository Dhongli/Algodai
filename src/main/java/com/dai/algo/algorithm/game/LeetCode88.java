package com.dai.algo.algorithm.game;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 88. 合并两个有序数组  https://leetcode.cn/problems/merge-sorted-array/
 * @date 2023/7/14 20:49
 */
public class LeetCode88 {
    public static void main(String[] args) {
        // int[] nums1 = {1,2,3,0,0,0};
        // int[] nums2 = {2,5,6};
        // merge(nums1, 3, nums2, 3);

        // int[] nums1 = {1};
        // int[] nums2 = {};
        // merge(nums1, 1, nums2, 0);

        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1, 0, nums2, 1);

        System.out.print("[");
        for (int i : nums1) {
            System.out.print(i);
            System.out.print(",");
        }
        System.out.print("]");
    }

    /**
     * @description: 自己的双指针
     * @param: nums1
     * @param: m
     * @param: nums2
     * @param: n
     * @return: void
     * @author daihongli
     * @date: 2023/7/14 21:38
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m, p2 = n;
        for (; p1 > 0 && p2 > 0; ) {
            if (nums1[p1 - 1] < nums2[p2 - 1]) {
                nums1[p1 + p2 - 1] = nums2[p2 - 1];
                p2--;
            } else {
                nums1[p1 + p2 - 1] = nums1[p1 - 1];
                // nums1[p1] = 0;
                p1--;
            }
        }
        if (p2 > 0) {
            for (int i = p2 - 1; i >= 0; i--) {
                nums1[i] = nums2[i];
            }
        }
    }
}
