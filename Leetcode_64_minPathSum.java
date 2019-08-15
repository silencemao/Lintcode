package main.java;


public class Leetcode_64_minPathSum {
    public static void main(String[] args){
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int res = minPathSum1(grid);
        System.out.println(res);
    }
    public static int minPathSum(int[][] grid){
        int res = 0;
        if (grid.length < 1 || grid[0].length < 1) return 0;
        if (grid.length==1) {
            for (int num : grid[0])
                res += num;
            return res;
        }
        if (grid[0].length==1){
            for (int[] num : grid)
                res += num[0];
            return res;
        }
        int m = grid.length, n = grid[0].length;

        for (int j=1; j<n; j++){
            grid[0][j] += grid[0][j-1];
        }
        for (int i=1; i<m; i++){
            grid[i][0] += grid[i-1][0];
            for (int j=1; j<n; j++){
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }

    public static int minPathSum1(int[][] grid){
        if (grid.length==0 || grid[0].length==0) return 0;

        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (i==0 && j==0) continue;
                else if (i==0) grid[0][j] += grid[0][j-1];
                else if (j==0) grid[i][0] += grid[i-1][0];
                else
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
