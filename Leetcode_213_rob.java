package main.java;

/**
 * https://leetcode.com/problems/house-robber-ii/discuss/60044/Good-performance-DP-solution-using-Java
 * 和第198题相似，给定一个数组nums，数组组成一个圆圈，从数组中取数，相邻位置的数不能同时取，第一个和最后一个数不能同时取
 * 可以从这个数组中取到的数的和的最大值
 *
 * 设置两个dp数组，一个从第一个位置的数开始取，这样最后一个位置的数就不能取了
 *             另一个从第二个位置的数开始取，可以取到最后一个数
 * 返回时比较两个第一个数组去掉最后一个数与第二个数组的最后一个数比较，返回最大值
 *
 * 第一个数组是从第一个数(index=0)开始取的，但是第二个数可以是前两个数中较大的一个
 * 第二个数组的第一个数为0，第二个数是nums的第二个数(index=1)
 * */
public class Leetcode_213_rob {
    public static void main(String[] args){
        int[] nums = {4,1,2,7,5,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length < 1) return 0;
        if (nums.length==1) return nums[0];
        if (nums.length==2) return Math.max(nums[0], nums[1]);
        int[] fromStartDp = new int[nums.length];
        int[] fromSecondDp = new int[nums.length];
        fromStartDp[0] = nums[0];
        fromStartDp[1] = Math.max(nums[0], nums[1]);
        fromSecondDp[0] = 0;
        fromSecondDp[1] = nums[1];

        for (int i=2; i<nums.length; i++){
            fromStartDp[i] = Math.max(fromStartDp[i-2] + nums[i], fromStartDp[i-1]);
            fromSecondDp[i] = Math.max(fromSecondDp[i-2] + nums[i], fromSecondDp[i-1]);
        }
        return Math.max(fromStartDp[nums.length-2], fromSecondDp[nums.length-1]);
    }
}
