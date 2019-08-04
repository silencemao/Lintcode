package main.java;

/**
 * 给定排序数组，去除重复的数字。
 * [1,1,2,3,3,4] 返回去除重复数字之后的数组长度4
 * 并且前4个位置为1 2 3 4
 * */
public class Leetcode_26_removeDuplicates {
    public static void main(String[] args){
        int[] nums = {1, 1};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums){
        int pos = 1;
        for (int i=1; i<nums.length; i++){
            if (nums[i] != nums[i-1]){
                nums[pos++] = nums[i];
            }
        }

        for (int i=0; i<pos; i++){
            System.out.println(nums[i]);
        }
        return pos;
    }
}
