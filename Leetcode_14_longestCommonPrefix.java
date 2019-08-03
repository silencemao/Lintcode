package main.java;

public class Leetcode_14_longestCommonPrefix {
    public static void main(String[] args){
        String[] strs = {"flow","flight","fllm"};
        System.out.println(longestCommonPrefix1(strs));
        String a = "nihaowo";
        String b = "hao";
        System.out.println(b.indexOf(a));
    }
    public static String longestCommonPrefix1(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            // pre=flow tmp=flight tmp.indexof(pre)=-1
            // pre=flo  tmp=flight tmp.indexof(pre)=-1
            // pre=fl   tmp=flight tmp.indexof(pre)=0
            // 判断如果 strs[i].indexof(pre) != 0 说明pre不是str[i]的前缀，pre需要去除最后一个字母
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }

    public static String help(String str1, String str2){
        if (str1.length() < 1 || str2.length() < 1){
            return "";
        }
        int l1 = 0;
        int l2 = 0;
        String prefix = "";

        while (l1 < str1.length() && l2 < str2.length()){
            if (str1.charAt(l1) == str2.charAt(l2)){
                prefix += str1.charAt(l1);
            }
            else {
                break;
            }
            l1 ++;
            l2 ++;
        }
        return prefix;
    }
    public static String longestCommonPrefix(String[] strs){
        if (strs.length < 1)
            return "";
        if (strs.length == 1)
            return strs[0];

        String prefix = strs[0];
        for (int i=1; i<strs.length; i++){
            prefix = help(prefix, strs[i]);
            if (prefix.length() < 1){
                break;
            }
        }
        return prefix;
    }
}
