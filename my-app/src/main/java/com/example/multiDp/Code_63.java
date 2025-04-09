package com.example.multiDp;

public class Code_63 {

    public static void main(String[] args) {

        int[][] p = new int[][]{ {0, 0, 0}, {0, 1, 0}, {0, 0,0 }};
        System.out.println(new Code_63().uniquePathsWithObstacles(p));

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        long[] dp = new long[obstacleGrid[0].length];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                long a1 = 0;
                long a2 = 0;
                if (i - 1 >= 0) {
                    a1 = dp[j];
                }
                if (j -1 >= 0) {
                    a2 = dp[j -1];
                }
                dp[j] = a1 + a2;
            }
        }

        return (int) dp[obstacleGrid[0].length -1];
    }

}
