package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * */
public class Leetcode_1_twoSum {
    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target){
        int res[] = new int[2];
        Map<Integer, Integer> numOfIndex = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            if (numOfIndex.containsKey(target-nums[i])){
                res[0] = numOfIndex.get(target-nums[i]);
                res[1] = i;
                break;
            }
            numOfIndex.put(nums[i], i);
        }

        return res;
    }
}
