package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *组合数的和，给定一个数组和一个目标值
 * 从数组中找出数字的组合，使其和为目标值，数组中的数字可以重复使用
 * */
public class Leetcode_39_combinationSum {
    public static void main(String[] args){
        int[] candidates = {1,2,3,6,7};
        int target = 8;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result.toString());
    }
    public static void helper(int[] candidates, int target, List<List<Integer>> result, int index, List<Integer> tmp, int sum){
        if (sum==target){
            result.add(new ArrayList<>(tmp));  // 进行new ArrayList<>()，否则在下一次调用改变tmp中的值，result也会跟着改变
            return;
        }
        for (int i=index; i<candidates.length; i++){
            if (sum > target || candidates[i] + sum > target)
                continue;
            tmp.add(candidates[i]);
            sum += candidates[i];
            helper(candidates, target, result, i, tmp, sum);  // 不用i+1，可以重复使用数字
            tmp.remove(tmp.size()-1);
            sum -= candidates[i];
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, result, 0, new ArrayList<>(), 0);
        return result;
    }


    public static void helper(int[] candidates, int target, List<List<Integer>> result, int index, List<Integer> tmp){
        if (target<0) return;
        if (0==target){
            result.add(new ArrayList<>(tmp));  //
            return;
        }
        for (int i=index; i<candidates.length; i++){
            if (candidates[i]>target) continue;
            tmp.add(candidates[i]);
            helper(candidates, target, result, i, tmp);  // 不用i+1，可以重复使用数字
            tmp.remove(tmp.size()-1);
        }
    }
    public static List<List<Integer>> combinationSum1(int[] candidates, int target){
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, result, 0, new ArrayList<>(), 0);
        return result;
    }
}
