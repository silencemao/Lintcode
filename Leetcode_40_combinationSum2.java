package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  组合数的和，给定一个数组和一个目标值，数组中有重复数字
 *  从数组中找出数字的组合，使其和为目标值，数组中的数字不可以重复使用。
 *  数组中重复的数字可以一起使用，比如数组中有两个1，这两个1可以一起使用
 * */
public class Leetcode_40_combinationSum2 {
    public static void main(String[] args){
        int[] candidates = {10,1,2,7,6,1,5,1};
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println(result.toString());
    }

    public static void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> tmp, int index){
        if (target < 0) return;
        if (target==0){
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i=index; i<candidates.length; i++){
            // i>index {1,1,1,...}当数组出现重复数字时，只允许第一个重复的数字可以配合后面相同的数字，其它的不可以，防止结果重复。
            // 如果是i>0的话，就是组合中不能有重复的数字
            if (candidates[i] > target || (i>index && candidates[i]==candidates[i-1])) continue;
            tmp.add(candidates[i]);
            helper(candidates, target-candidates[i], result, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }
}
