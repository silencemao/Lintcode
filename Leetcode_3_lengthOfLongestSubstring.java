package main.java;

import javax.swing.text.AttributeSet;
import java.util.HashMap;
import java.util.Map;

/**
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * */
public class Leetcode_3_lengthOfLongestSubstring {
    public  static void main(String[] args){
        String s = "abba";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public static int lengthOfLongestSubstring(String s){
        if (s.length() < 1){
            return 0;
        }

        int result = 0;
        // 记录上次出现的位置 abba为例，bb是重复的子串，lastpos记录的是第一个b出现的位置，当遍历到最后一个a时，
        // 第一个a出现的位置在lastpos之前，说明中间有重复字符串，lastPos不能更新为0,应该按照目前的数来计算
        int lastPos = -1;
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<s.length(); i++){
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) > lastPos){
                lastPos = map.get(s.charAt(i));
            }

            if (i - lastPos > result){
                result = i - lastPos;
            }

            map.put(s.charAt(i), i);
        }

        return result;
    }
}
