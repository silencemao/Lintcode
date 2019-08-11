package main.java;

/**
 * 给定一个排序数组，和一个目标值target
 * 如果target在数组中，返回target的索引，如果不在，返回target插入数组中的索引。
 *
 * */
public class Leetcode_35_searchInsert {
    public static void main(String[] args){
        int[] nums = {1, 3, 5, 6};
        int target = 6;
        System.out.println(searchInsert(nums, target));
    }

    /**
     * 二分法防止陷入死循环
     * 只剩两个数字的时候while(left<right) (left+mid)>>1 = left，要想跳出死循环就要left=mid+1 right=mid/right=mid-1都可以
     * 或者是在while(left<=right) 这样left就能多加一次1了，(left+right)>>1=left=right 要跳出循环要设置 right=mid-1
     * */
    public static int searchInsert(int[] nums, int target){
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (nums[mid]==target) return mid;

            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
