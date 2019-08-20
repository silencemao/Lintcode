package main.java;

/**
 * 最长上升子序列
 * */
public class Lintcode_76_longestIncreasingSubsequence {
    public static void main(String[] args){
        int[] nums = {10,1,11,2,12,3,11};
        int result = longestIncreasingSubsequence(nums);
        System.out.println(result);
    }

    // 4 2 4 5 3 7
    public static int longestIncreasingSubsequence(int[] nums){
        if (nums.length < 1) return 0;
        int[] dp = new int[nums.length];

        dp[0] = 1;
        int res = 0;
        for (int i=1; i<nums.length; i++){
            dp[i] = 1;    // 初始化为1，相当于它自身的长度
            for (int j=0; j<i; j++){
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                else
//                    dp[i] = 1;   这样写会把dp[i]重新变成1，j之前位置小于num[i]的数字全部作废了
                res = Math.max(res, dp[i]);
            }
        }

        return res;
    }
}
