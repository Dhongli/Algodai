package com.dai.algo.algorithm.erchashu;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class twoSum {
    public static void main(String[] args) {
        int target = 9;
        int[] nums = new int[]{2, 7, 11, 15};
        int[] sumArray = getTwoSum(target, nums);
        System.out.println("[" + sumArray[0] + "," +sumArray[1] + "]");
    }

    private static int[] getTwoSum(int target, int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }
}
