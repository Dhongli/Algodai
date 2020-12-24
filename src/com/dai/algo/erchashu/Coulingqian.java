package com.dai.algo.erchashu;

import java.util.Arrays;

/**
 * 322.零钱兑换,给你K种面值金币,面值分别为C1,C2....Ck,每种硬币数量不限,再给一个总金额amount,问你最少需要
 * 几枚硬币凑出这个金额,如果不能凑出算法返回-1.
 */
public class Coulingqian {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        int i = coinChange(coins, amount);
        System.out.println(i);
    }

    /**
     * 动态规划,自底向上
     * @param coins
     * @param amount
     * @return
     */
    // coins 可选面值,amount 目标金额 动态转移方程: F(n) = F(n - coins[i]) + 1;其中1为一个coins[i]的面值的硬币
    private static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int len = coins.length;
        if (len == 0 || amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount +1);
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = coins[i];j <= amount; ++j) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] <= amount? dp[amount]:-1;
    }
}
