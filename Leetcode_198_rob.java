package main.java;
/**
 * https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 * 店铺抢劫，相邻的店铺不能同时抢劫，所以能获得最多的钱是多少。
 * 定一个数组dp，dp[i]表示以i结尾能获得的最多钱
 * 两种情况，当前位置抢劫，dp[i] = dp[i-2] + nums[i]
 *      当前位置不能抢劫，dp[i] = dp[i-1]
 *      dp取二者最大值即可
 * */

public class Leetcode_198_rob {
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums){
        if (nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }

}
