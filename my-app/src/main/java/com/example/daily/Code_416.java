package com.example.daily;

public class Code_416 {

    public static void main(String[] args) {

        System.out.println("new Code_416().canPartition(new int[]{1,2 ,3 ,4 ,5}) = " + new Code_416().canPartition(new int[]{1,3,4,4}));

    }


    public boolean canPartition(int[] nums) {

        if (nums.length < 2 ) {
            return false;
        }
        int total = 0;
        int max = -1;

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            max = Math.max(max, nums[i]);
        }
        if (total % 2 != 0 || total/2 < max) {
            return false;
        }
        int length = total/2 + 1;

        boolean[] dp = new boolean[length];
        dp[0] = true;
        dp[nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {

            for (int j = length -1; j >= 0; j --) {
                if ( j - nums[i] >=0 ) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }

        }
        return dp[total/2];
    }

}
