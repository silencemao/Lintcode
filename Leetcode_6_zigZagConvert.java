package main.java;

import java.util.ArrayList;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * */
public class Leetcode_6_zigZagConvert {
	public static void main(String[] args) {
		System.out.println(convert("AB", 1));
	}
	
	public static String convert(String s, int numRows) {
		if (numRows < 2 || numRows > s.length()) {
			return s;
		}
		
		String result = "";
		ArrayList<String> tmp = new ArrayList<String>();
		for (int i=0; i<numRows; i++) {
			tmp.add("");
		}
		
		int row = 0;
		int step = 1;
		
		for (int i = 0; i < s.length(); i ++) {
			if (row == numRows - 1) {
				step = -1;
			}
			if (row==0) {
				step = 1;
			}
			tmp.set(row, tmp.get(row) + s.charAt(i));
			row += step;
		}
		
		for (String str : tmp) {
			result += str;
		}
		return result;
	}
}
