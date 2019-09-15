package main.java;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * 给一堆零钱coins 以及一个目标amount
 * 求用最短多少个零钱可以组成amount 不能组成则返回-1
 * */
public class Leetcode_322_coinChange {
    public static void main(String[] args){
        int[] coins = {2};
        int amount = 11;
        int result = coinChange(coins, amount);
        System.out.println(result);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i=1; i<=amount; i++){
            dp[i] = Integer.MAX_VALUE;
            for (int j=0; j<coins.length; j++){
                // coins[j] <= j 是防止i变成负数  dp[i-coins[j]] != Integer.MAX_VALUE 防止dp中的数变成Integer.MAX_VALUE/MINVALUE
                if (coins[j] <= i && dp[i-coins[j]]!= Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }

            }
        }

        return dp[amount]==Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
