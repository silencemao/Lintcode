package main.java;

/**
 * 判断数字是否为回文
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 *
 * */
public class Leetcode_9_isPalindrome {
    public static void main(String[] args){
        System.out.println(isPalindrome1(121));
    }

    public static boolean isPalindrome(int x){
        if (x < 0){
            return false;
        }
        int maxValue = 2147483647;
        int result = 0;
        int tmp = x;
        while (tmp != 0){
            int m = tmp % 10;
            if (result > maxValue / 10){
                return false;
            }
            result = result * 10 + m;
            tmp /= 10;
        }

        return x==result;
    }

    public static boolean isPalindrome1(int x){
        if (x < 0){
            return false;
        }
        String str = String.valueOf(x);
        String tmp = new StringBuilder(str).reverse().toString();
        return str.equals(tmp);
    }
}
