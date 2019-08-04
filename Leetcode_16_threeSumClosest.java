package main.java;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/**
 * 最接近target的三数之和
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is
 * closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * */
public class Leetcode_16_threeSumClosest {
    public static void main(String[] args){
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target){
        int res = 2147483647;
        int diff = 2147483647;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1; i++){
            int left = i+1, right = nums.length-1;
            while (left < right){
                int tmp = nums[i] + nums[left] + nums[right];
                if (tmp==target){
                    res = tmp;
                    return res;
                }
                else if (tmp < target){
                    if (target - tmp < diff){
                        diff = target - tmp;
                        res = tmp;
                    }
                    while (left < right && nums[left]==nums[left+1]) left++;
                    left++;
                }
                else{
                    if (tmp - target < diff){
                        diff = tmp - target;
                        res = tmp;
                    }
                    while (left < right && nums[right]==nums[right-1]) right--;
                    right--;
                }
            }
        }
        return res;
    }

    public static int threeSumCloest1(int[] nums, int target){
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length-1];
        for (int i=0; i<nums.length-1; i++){
            int left = i +1, right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target){
                    left++;
                }
                else {
                    right--;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)){
                    result = sum;
                }
            }
        }
        return result;

    }
}
