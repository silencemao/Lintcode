package main.java;

public class Leetcode_303_numArray {
    public static void main(String[] args){
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Leetcode_303_numArray obj = new Leetcode_303_numArray(nums);
        System.out.println(sumRange(0, 5));
    }

    private static int[] nums;
    public Leetcode_303_numArray(int[] nums){
        for (int i=1; i<nums.length; i++){
            nums[i] += nums[i-1];
        }
        this.nums = nums;
    }
    public static int sumRange(int i, int j) {
        if (i==0)
            return nums[j];
        return nums[j] - nums[i-1];
    }
}
