package main.java;

/**
 * 最长上升子序列
 * 不是最长连续上升子序列
 * */
public class Leetcode_300_lengthOfLIS {
    public static void main(String[] args){
        int[] nums = {10, 9, 2, 5, 3, 4};
        int result = lengthOfLIS(nums);
        System.out.println(result);
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length < 1) return 0;
        int[] dp = new int[nums.length];
        int result = 1;
        dp[0] = 1;
        for (int i=1; i<nums.length; i++){
            dp[i] = 1;
            for (int j=0; j<i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
//                else {            这样写不对，对于上面的例子，i=5,j=2时，dp[i]=2, j=3时，dp[i]=1 明显的把j=2时dp[i]的值给删除了。
//                    dp[i] = 1;
//                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
