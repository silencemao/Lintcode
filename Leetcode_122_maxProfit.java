package main.java;

/**
 *
 * 最大利润，支持多次买卖，第二次买入必须先卖掉
 * */
public class Leetcode_122_maxProfit {
    public static void main(String[] args){
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(prices);

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices){
        int result = 0;
        for (int i=0; i<prices.length-1; i++){
            if (prices[i] < prices[i+1]){   // 如果今天的价格低于明天的价格，那今天买入，第二天卖出，[1 2 3 4] 相当于第0天买入，第3天卖出 result=3
                result += (prices[i+1] - prices[i]);
            }
        }
        return result;
    }
}
