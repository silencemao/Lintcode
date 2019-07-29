package main.java;

/**
 * 最大盛水容器，
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 * */
public class Leetcode_11_maxArea {
    public static void main(String[] args){
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height){
        int result = 0;
        if (height.length < 2){
            return 0;
        }
        int left = 0, right = height.length-1;
        while (left < right){
            int tmp = (right - left) * (height[left] < height[right] ? height[left++] : height[right--]);
            result = result > tmp ? result : tmp;
        }

        return result;
    }
}
