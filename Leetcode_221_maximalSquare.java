package main.java;

/**
 * 最大的正方形面积
 * 给定一个二维数组matrix，数组内为数字1或0，找出由1组成的正方形的最大面积
 *
 * 动态规划，第0行和第0列中只要matrix[i][j]=1，面积就是1
 * 从第1行和第1列开始，matrix[i][j]位置的数如果为1，就要看其左边、上边、左上角三个位置的数的最小值
 * 取最小值加1，就可以得到正方形的边长。
 * 将问题转化为，求最大正方形的边长。
 * */
public class Leetcode_221_maximalSquare {
    public static void main(String[] args){
        char[][] matrix = {{'1', '0'}};
        int result = maximalSquare(matrix);
        System.out.println(result);
    }

    public static int maximalSquare(char[][] matrix) {
        if (matrix.length==0) return 0;
        if (matrix[0].length==0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];
        int result = 0;

        for (int i=1; i<=row; i++){
            for (int j=1; j<=col; j++){
                if (matrix[i-1][j-1]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result*result;
    }
}
