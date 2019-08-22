package main.java;

/**
 *
 *     r a b
 *   1 0 0 0
 * r 1 1 0 0
 * a 1 1 1 0
 * b 1 1 1 1
 * b 1 1 1 2
 *
 * */

public class Leetcode_115_numDistinct {
    public static void main(String[] args){
        String S = "rabb";
        String T = "rab";
        System.out.println(numDistinct(S, T));
    }

    public static int numDistinct(String S, String T){
        int[][] res = new int[S.length()+1][T.length()+1];

        // 第一列全为1，当T=""时，任何字符串删掉所有字符都可以组成它，但只有一种结果
        // 第一行除了第一个位置外，其它全为0，当S=""时，不能组成任何非空的T
        for (int i=0; i<S.length()+1; i++)
            res[i][0] = 1;

        for (int i=1; i<res.length; i++){
            for (int j=1; j<res[0].length; j++){
                if (S.charAt(i-1)==T.charAt(j-1))   //  前一个字符的组成个数 与 当前位置的字符的组成个数之和
                    res[i][j] = res[i-1][j-1] + res[i-1][j];
                else
                    res[i][j] = res[i-1][j];
            }
        }

        return res[S.length()][T.length()];
    }
}
