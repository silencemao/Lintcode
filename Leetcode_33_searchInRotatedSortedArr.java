package main.java;

// 旋转数组中寻找target的索引
public class Leetcode_33_searchInRotatedSortedArr {
    public static void main(String[] args){
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid]==target)
                return mid;

            if (nums[left] <= nums[mid]){
                if (nums[left] <= target && target <= nums[mid]){
                    right = mid-1;
                }
                else {
                    left = mid + 1;
                }
            }

            if (nums[mid] <= nums[right]){
                if (nums[mid] <= target && target <= nums[right]){
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
