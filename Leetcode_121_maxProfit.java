package main.java;

/**
 * 给定一个数组prices prices[i]代表物品在第i天的价格，决定在哪天买入，哪天卖出获益最多，返回获益的值。
 * 只能进行一次交易。
 * */
public class Leetcode_121_maxProfit {
    public static void main(String[] args){
        int[] prices = {1, 2};
        System.out.println(maxProfit1(prices));
    }

    public static int maxProfit(int[] prices){
        int n = prices.length;
        int[] result = new int[n];
        int res = 0;
        result[0] = 0;
        for (int i=0; i<n; i++){
            for (int j=i; j<n && prices[j] >= prices[i]; j++){
                result[i] = Math.max(result[i], prices[j]-prices[i]);
                res = Math.max(res, result[i]);
            }
        }
        return res;
    }

    public static int maxProfit1(int[] prices){
        if (prices.length < 1) return 0;
        int maxCur = 0, result = 0;
        for (int i=1; i<prices.length; i++){
            maxCur = Math.max(0, maxCur + prices[i]-prices[i-1]);
            result = Math.max(result, maxCur);
        }
        return result;
    }
}
