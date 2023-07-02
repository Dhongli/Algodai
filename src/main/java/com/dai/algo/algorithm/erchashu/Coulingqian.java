package com.dai.algo.algorithm.erchashu;

import java.util.Arrays;

/**
 * 322.零钱兑换,给你K种面值金币,面值分别为C1,C2....Ck,每种硬币数量不限,再给一个总金额amount,问你最少需要
 * 几枚硬币凑出这个金额,如果不能凑出算法返回-1.
 */
public class Coulingqian {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
//        int i = coinChange(coins, amount);
        int i = coinChange1(coins, amount);
        System.out.println(i);
    }

    /**
     * 动态规划,自底向上
     *
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
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = coins[i]; j <= amount; ++j) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] <= amount ? dp[amount] : -1;
    }

    // 自顶向下
    static int[] memo;

    public static int coinChange1(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[amount];

        return findWay(coins, amount);
    }

    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public static int findWay(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findWay(coins, amount - coins[i]);
            if (res >= 0 && res < min) {
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];
    }
}
