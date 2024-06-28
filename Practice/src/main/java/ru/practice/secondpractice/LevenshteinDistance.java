package ru.practice.secondpractice;

public class LevenshteinDistance {

    public static int task(String firstStr, String secondStr) {
        int lenOfFirstStr = firstStr.length();
        int lenOfSecondStr = secondStr.length();

        int[][] dp = new int[lenOfFirstStr + 1][lenOfSecondStr + 1];

        for (int i = 0; i <= lenOfFirstStr; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= lenOfSecondStr; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= lenOfFirstStr; i++) {
            for (int j = 1; j <= lenOfSecondStr; j++) {
                int cost = (firstStr.charAt(i - 1) == secondStr.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(
                        dp[i - 1][j] + 1,
                        dp[i][j - 1] + 1
                ), dp[i - 1][j - 1] + cost);
            }
        }

        return dp[lenOfFirstStr][lenOfSecondStr];
    }
}

