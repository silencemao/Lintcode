package main.java;

// 连续数组的最大乘积
// https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity
public class Leetcode_152_maxProduct {
    public static void main(String[] args){
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct2(nums));
    }

    public static int maxProduct(int[] nums){
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int result = Math.max(Integer.MIN_VALUE, dpMax[0]);
        for (int i=1; i<nums.length; i++){
            dpMax[i] = Math.max(Math.max(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]), nums[i]);
            dpMin[i] = Math.min(Math.min(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]), nums[i]);
            result = Math.max(result, Math.max(dpMax[i], dpMin[i]));
        }
        return result;
    }

    public static int maxProduct1(int[] nums){
        int preMax = nums[0], preMin = nums[0], result = nums[0];
        for (int i=1; i < nums.length; i++){
            int tMax = Math.max(Math.max(preMax * nums[i], preMin * nums[i]), nums[i]);
            int tMin = Math.min(Math.min(preMax * nums[i], preMin * nums[i]), nums[i]);
            preMax = tMax;
            preMin = tMin;
            result = Math.max(Math.max(preMax, preMin), result);
        }
        return result;
    }

    public static int maxProduct2(int[] nums){
        int r = nums[0];
        for (int i=1, imax=r, imin=r; i<nums.length; i++){
            if (nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }

            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);
            r = Math.max(imax, r);
        }
        return r;
    }
}
