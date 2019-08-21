package main.java;

/**
 * 在排序数组中找出与target最接近的数字
 * */
public class Lintcode_459_closestNumber {
    public static void main(String[] args){
        int[] nums = {1, 4, 6};
        int target = 5;
        System.out.println(closestNumber(nums, target));
    }

    public static int closestNumber(int[] nums, int target){
        if (nums==null || nums.length < 1) return -1;
        int index = findIndex(nums, target);
        if (index==0) return 0;
        if (index==nums.length)
            return nums.length-1;
        if (Math.abs(nums[index]-target) < Math.abs(nums[index-1]-target))
            return index;
        return index-1;
    }

    public static int findIndex(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while (left+1 < right){
            int mid = (left + right) >> 1;
            if (nums[mid]==target)
                return mid;
            else if (nums[mid] > target)
                right = mid;
            else
                left = mid;
        }
        if (nums[right] >= target)
            return right;
        if (nums[left] >= target)
            return left;
        return nums.length;
    }
}
