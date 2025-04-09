package com.example.multiDp;

public class Code_64 {

    public static void main(String[] args) {

        int[][] p = new int[][]{ {1, 3, 1}, {1, 5 ,1}, {4, 2,1}};
        System.out.println(new Code_64().minPathSum(p));
    }

    public int minPathSum(int[][] grid) {

        int[]dp = new int[grid[0].length];

        dp[0] = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int a1 = Integer.MAX_VALUE;
                int a2 = Integer.MAX_VALUE;
                if (i -1 >= 0) {
                    a1 = dp[j];
                }
                if (j -1 >= 0) {
                    a2 = dp[j -1];
                }
                dp[j]  = Math.min(a1, a2) + grid[i][j];
            }
        }
        return dp[grid[0].length - 1];
    }

}
