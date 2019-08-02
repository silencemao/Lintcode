package main.java;

/**
 * 罗马字符串转换成数字
 * https://leetcode-cn.com/problems/roman-to-integer/
 * 
 * */
public class Leetcode_13_romanToInt {
    public static void main(String[] args){
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanCharToInt(char ch){
        switch (ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
    public static int romanToInt(String s){
        if (s.length() < 1)
            return 0;
        int result = romanCharToInt(s.charAt(0));
        for (int i=1; i<s.length(); i++){
            int prev = romanCharToInt(s.charAt(i-1));
            int cur = romanCharToInt(s.charAt(i));
            if (prev < cur){
                result = result - prev + (cur - prev);
            }
            else {
                result += cur;
            }
        }
        return result;
    }
}
