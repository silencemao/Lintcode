package main.java;

/**
 *
 * 买卖可以获得的最大收益，在一天内可以买入、卖出、什么都不干
 * 但是卖出之后必须休息一天才能买入
 *  1    2   3    0    5  最大收益是6
 * buy sell cool buy sell
 * 卖出只能由 已有收益hold 和 卖出的价格price得到
 * hold只能由 之前的已有收益 和 休息再之后买入来得到
 * rest只能由 之前的rest 和 前面卖出的价格得到  所以提前用prev_sold来保存已经卖出的价格
 *
 * */
public class Leetcode_309_maxProfit {
    public static void main(String[] args){
        int[] prices = {1, 2, 3, 0, 5};
        Solution solution = new Solution();
        int result = solution.maxProfit(prices);
        System.out.println(result);
    }
}

class Solution{

    public int maxProfit(int[] prices){
        int sold = 0;
        int hold = Integer.MIN_VALUE;
        int rest = 0;
        for (int price : prices){
            int prev_sold = sold;
            sold = hold + price;
            hold = Math.max(hold, rest - price);
            rest = Math.max(rest, prev_sold);     // 这里不能用sold
        }
        return Math.max(rest, sold);
    }
}
