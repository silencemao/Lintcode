package main.java;


import java.util.ArrayList;
import java.util.List;

/**
 * 移动0
 * */
public class Lintcode_539_move0 {
    public static void main(String[] args){
        int[] nums= new int[10];
        for (int i=1; i<6; i++){
            nums[i*2-2] = 0;
            nums[i*2-1] = i;
        }
//        for (int i=0; i<nums.length; i++){
//            System.out.println(nums[i]);
//        }
        move0(nums);
        for (int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
    }

    public static void move0(List<Integer> nums){
        int position = 0;
        for (int i=0; i<nums.size(); i++){
            if (nums.get(i) != 0){
                if (i != position){
                    nums.set(position, nums.get(i));
                }
                position++;
            }
        }
        for (; position<nums.size(); position++){
            nums.set(position, 0);
        }
    }

    public static void move0(int[] nums){
        int position= 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] != 0){
                if (i != position){
                    nums[position] = nums[i];
                }
                position++;
            }
        }
        for (; position < nums.length; position++){
            nums[position] = 0;
        }
    }
}
