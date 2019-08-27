package main.java;

import java.lang.reflect.Array;
import java.util.*;

public class Leetcode_139_wordBreak {
    public static void main(String[] args){
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);  // 对wordDict去重
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i=1; i<=s.length(); i++){
            for (int j=0; j<i; j++){
                // 必须f[j]=true,相当于从上一个在dict中的子串结尾开始。从 j～i 之间的子串是否在dict中
                if (f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;   // 如果子串(j~i)在dict中，则(j+1)~i就不需要考虑了
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
