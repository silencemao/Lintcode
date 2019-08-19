package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 * */
public class Leetcode_91_numDecodings {
    public static void main(String[] args){
        String s = "12";
        int result = numDecodings1(s);
        System.out.println(result);
    }

    public static void help(String s, List<String> result, List<String> cur, int index){
        if (index > s.length()){
            result.add(String.join("", cur));
            return;
        }
        Map<String, String> map = new HashMap<>();
        String abChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i=1; i<27; i++){
            map.put(String.valueOf(i), abChar.substring(i-1, i));
        }
        for (int i=index; i < index+2 && i<s.length(); i++){
            String tmp = s.substring(index, Math.min(i, s.length()));
            if (map.containsKey(tmp))
                cur.add(map.get(tmp));

            help(s, result, cur, index+1);

            if (cur.size() > 0)
                cur.remove(cur.size()-1);
        }
    }
    public static int numDecodings(String s){
        if (s.isEmpty()) return 0;
        List<String> result = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        help(s, result, cur, 0);

        return result.size();
    }

    public static int numDecodings1(String s){
        if (s==null || s.length() < 1) return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i=2; i<=n; i++){
            int first = Integer.parseInt(s.substring(i-1, i));
            int second = Integer.parseInt(s.substring(i-2, i));
            if (first >= 1 && first <= 9)
                dp[i] += dp[i-1];
            if (second >= 10 && second<=26)
                dp[i] += dp[i-2];
        }
        return dp[n];
    }
}
