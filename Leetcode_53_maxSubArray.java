package main.java;

public class Leetcode_53_maxSubArray {
    public static void main(String[] args){
        int[] nums = {5, 2, -5, -1, 6, 1, -7};
        int result = maxSubArray(nums);
        System.out.println(result);
    }

    public static int maxSubArray(int[] nums){
        if (nums.length < 1) return 0;
        int res = nums[0], cur = nums[0];
        for (int i=1; i<nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            res = Math.max(res, cur);
        }

        return res;
    }
}
