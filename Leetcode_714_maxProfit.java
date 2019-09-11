package main.java;

/**
 * 股票买卖的最大收益，可以进行多次交易，但是每次交易都会有手续费
 * */
public class Leetcode_714_maxProfit {
    public static void main(String[] args){
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int result = maxProfit(prices, fee);
        System.out.println(result);
    }

    /**
     * 每天的状态可以是手里有股票，手里无股票
     *
     * 有股票可能是一直维持前面的状态，或者是新买入股票   cash表示
     * 无股票可能是一直位置前面的状态，或者是刚卖掉      hold表示
     *
     * cash要在hold之前，因为先卖掉才能再买
     * */
    public static int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i=1; i<prices.length; i++){
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
