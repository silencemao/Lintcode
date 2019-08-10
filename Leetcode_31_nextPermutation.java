package main.java;

import java.util.Arrays;

/**
 * 下一个排列，
 * 给定一个数组，对数组中的数字进行调整，变成比当前数组大的最小的组合。
 * 1， 2， 3 -》 1， 3， 2
 * 1，8，9，6，5 -》 1，9，5，6，8
 *
 * 从倒数第二个数字开始，逐个与后一位的数字进行比较，如果nums[i] < nums[i+1]，说明 i 位置处可以变成一个比nums[i]大的数
 * 应该从i+1位置到最后一个数之间选取一个大于nums[i]的最小的数，将其与nums[i]交换，然后将i位置后面的数从小到大排序。
 * */
public class Leetcode_31_nextPermutation {
    public static void main(String[] args){
        int[] nums = {1, 3, 2};
        System.out.println(Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void nextPermutation(int[] nums){
        boolean flag = false;
        for (int i=nums.length-2; i>=0; i--){
            if (nums[i] < nums[i+1]){
                int k = nums.length-1;
                while (k >= i+1){
                    if (nums[k] > nums[i]){
                        int temp = nums[i];
                        nums[i] = nums[k];
                        nums[k] = temp;
                        flag = true;
                        Arrays.sort(nums, i+1, nums.length);
                        break;
                    }
                    k--;
                }
            }
            if (flag)
                break;
        }
        if (!flag){
            Arrays.sort(nums);
        }
    }
}
