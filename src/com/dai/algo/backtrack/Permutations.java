package com.dai.algo.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 46.全排列:给定一个没有重复数字的序列,返回其所有可能的全排列
 */
public class Permutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3,4}));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for (int num : nums) {
            path.add(num);
        }
        int n = nums.length;
        getSolution(n, 0, res, path);
        return res;
    }
    public static void getSolution(int n, int first, List<List<Integer>> res, List<Integer> path) {
        if (first == n) {
            res.add(new ArrayList<>(path));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(path, i, first);
            getSolution(n, first + 1, res, path);
            Collections.swap(path, first, i);
        }
    }

}
