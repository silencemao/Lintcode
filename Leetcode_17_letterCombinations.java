package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码组合
 * */
public class Leetcode_17_letterCombinations {
    public static void main(String[] args){
        List<String> res = letterCombinations("234");
        for (String str: res){
            System.out.println(str);
        }
    }

    public static List<String> letterCombinations(String digits){
        List<String> res = new ArrayList<>();
        if (!digits.isEmpty()){
            helper(res, "", 0, digits);
        }
        return res;
    }
    public static void helper(List<String> list, String cur, int position, String digits){
        if (cur.length() == digits.length()){
            list.add(cur);
            return;
        }
        String[] chars = getMapping(digits.charAt(position));
        for (int i=0; i<chars.length; i++){
            helper(list, cur + chars[i], position + 1, digits);
        }
    }

    public static String[] getMapping(char c) {
        switch (c) {
            case '2':
                return new String[] {"a", "b", "c"};
            case '3':
                return new String[] {"d", "e", "f"};
            case '4':
                return new String[] {"g", "h", "i"};
            case '5':
                return new String[] {"j", "k", "l"};
            case '6':
                return new String[] {"m", "n", "o"};
            case '7':
                return new String[] {"p", "q", "r", "s"};
            case '8':
                return new String[] {"t", "u", "v"};
            case '9':
                return new String[] {"w", "x", "y", "z"};
        }

        return new String[] {};
    }

}
