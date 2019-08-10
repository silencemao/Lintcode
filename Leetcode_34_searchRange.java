package main.java;

import java.util.Arrays;

// 寻找target在排序数组中出现的区间
public class Leetcode_34_searchRange {
    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target){
        int res[] = {-1, -1};
        if (nums.length < 1 || target < nums[0] || target > nums[nums.length-1])
            return res;

        int left = 0, right = nums.length - 1;
        // 找左边界
        while (left < right){
            int mid = (left + right) >> 1;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }

        if (nums[left]==target)
            res[0] = left;
        right = nums.length - 1;
        while (left < right){
            // 防止死循环  if u dont do it, the mid always tends to the left, by adding 1,
            // we asking mid to go to right, which is what we want.
            // + 1 is like the divide operator then takes the next whole number
            int mid = ((left + right) >> 1) + 1;
            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid;
        }

        if (nums[right]==target)
            res[1] = right;
        return res;
    }
}
