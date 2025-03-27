package com.example.dp;

import java.util.Arrays;

/**
 * 一维动态规划， 零钱兑换
 */
public class Code_322 {

    public static void main(String[] args) {
        System.out.println(new Code_322().coinChangeDp(new int[]{1, 2, 5}, 100));
    }


    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinSubChange(coins, amount, new int[amount]);
    }

    public int coinSubChange(int[] coins, int amount, int[] record) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (record[amount -1] != 0) {
            return record[amount -1];
        }
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subCount = coinSubChange(coins, amount - coins[i], record);
            if (subCount >= 0 && subCount < count) {
                count = subCount + 1;
            }
        }
        record[amount - 1] = (count == Integer.MAX_VALUE) ? -1 : count;
        return record[amount - 1];
    }

    public int coinChangeDp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0 || dp[i - coin] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }



}
