package com.example.dp;

import java.util.Arrays;

public class Code_300 {

    public static void main(String[] args) {
        System.out.println(new Code_300().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }


    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
