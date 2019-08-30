package main.java;

/**
 * 完美平方数 1 2 4 9 16
 * 给定一个数n，找出它最少可以由几个完美平方数构成
 *
 * 动态规划，类似与背包问题
 * */
public class Leetcode_279_numSquares {
    public static void main(String[] args){
        int n = 12;
        int result = numSquares(n);
        System.out.println(result);
    }

    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i=1; i<=n; i++){
            dp[i] = Integer.MAX_VALUE;
            for (int j=1; j*j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }


}
