package main.java;

/**
 * 唯一的路径，给定一个m列n行的矩阵，从左上角出发，每一步只能向右或者向下走，走到右下角有多少路径
 * 第一行第一列都是一种路径，中间的都是左边和上边的和。
 * */
public class Leetcode_62_uniquePaths {
    public static void main(String[] args){
        int m = 7, n = 3;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n){
        if (m < 1 || n < 1) return 0;
        if (m==1 || n==1) return 1;

        int[][] arr = new int[m][n];
        for (int i=0; i<m; i++) arr[i][0] = 1;
        for (int i=0; i<n; i++) arr[0][i] = 1;
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
}
