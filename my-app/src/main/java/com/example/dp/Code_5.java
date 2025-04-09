package com.example.dp;

/**
 *
 * int a= "babad"
 */
public class Code_5 {

    public static void main(String[] args) {

        System.out.println(new Code_5().longestPalindrome("absas12"));
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }
        char[] charArray = s.toCharArray();
        boolean[][]dp = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int maxIndex = 0;
        int maxLength = 1;
        for (int i = 1; i < length; i++) {
            for(int j  = 0; j < length; j++) {
                int end = j + i;
                if (end >= length) {
                    break;
                }
                if (i == 1) {
                    dp[j][end] = charArray[j] == charArray[end];
                } else {
                    dp[j][end] = dp[j + 1][end -1] && (charArray[j] == charArray[end]);
                }
                if (dp[j][end] && i + 1 > maxLength) {
                    maxIndex = j;
                    maxLength = i + 1;
                }
            }
        }
        return s.substring(maxIndex, maxIndex + maxLength);
    }


    public String longestPalindromeSUB(String s) {
        int[][] dp = new int[s.length()][2];

        char[] charArray = s.toCharArray();

        dp[0][0] = 1;
        dp[0][1] = 0;

        Integer maxIndex = 0;
        Integer maxCount = 1;

        for (int i = 1; i < charArray.length; i++) {
            int j1 = i - 1 -  dp[i-1][0];
            int j2 = i - 1 - dp[i-1][1];

            if (j1 >= 0) {
                dp[i][0] = (charArray[j1] == charArray[i]) ?  dp[i-1][0] + 2 : 1;
            } else {
                dp[i][0] = 1;
            }

            if (j2 >= 0) {
                dp[i][1] = (charArray[j2] == charArray[i] ? dp[i-1][1] + 2 : 0 );
            } else {
                dp[i][1] = 0;
            }
            if (dp[i][0] > maxCount) {
                maxIndex = i;
                maxCount = dp[i][0];
            }
            if (dp[i][1] > maxCount) {
                maxIndex = i;
                maxCount = dp[i][1];
            }
        }

        return s.substring( maxIndex + 1 - maxCount,maxIndex + 1);
    }
}
