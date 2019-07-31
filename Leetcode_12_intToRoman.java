package main.java;

/**
 * 整数转罗马
 * 示例 1:
 *
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: 9
 * 输出: "IX"
 * */
public class Leetcode_12_intToRoman {
    public static void main(String[] args){
        System.out.println(intToRoman(1999));
    }

    public static String intToRoman(int num){
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value = {1000,     900, 500, 400, 100,   90,  50,   40,   10,   9  ,  5,  4,    1} ;
        String res = "";
        for (int i=0; num!=0; i++){
            while (num >= value[i]){
                res += symbol[i];
                num -= value[i];
            }
        }
        return res;
    }
}
