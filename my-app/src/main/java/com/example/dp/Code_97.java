package com.example.dp;

import java.lang.ref.WeakReference;

public class Code_97 {

    public static void main(String[] args) {

        ThreadLocal<Object> a = new ThreadLocal<>();
        a.set(1);
        a.get();

        WeakReference<String> a1 = new WeakReference<>("sdfdsfsdf");


        boolean interleave = new Code_97().isInterleave("aabcc", "dbbca", "aadbbcbcac");

        System.out.println(interleave);
    }


    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.equals("")) {
            return s2.equals(s3);
        }
        if (s2.equals("")) {
            return s1.equals(s3);
        }

        boolean[]dp = new boolean[s2.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                int index = i + j - 1;
                if (i > 0) {
                    dp[j] = (dp[j] && s1.charAt(i-1) == s3.charAt(index));
                }
                if (j > 0) {
                    dp[j] = dp[j] || (dp[j-1] && s2.charAt(j-1) == s3.charAt(index));
                }
            }
        }
        return dp[s2.length()];
    }
}
