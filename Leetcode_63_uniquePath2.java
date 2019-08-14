package main.java;

/**
 * 带障碍的路径个数
 * */
public class Leetcode_63_uniquePath2 {
    public static void main(String[] args){
        int[][] obstacleGrid = {{1, 0}, {0, 0}};
        int result = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(result);

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m < 1 || n < 1) return 0;
        if (obstacleGrid[0][0]==1) return 0;
        if (m==1){
            for (int num : obstacleGrid[0])
                if (num==1){
                    return 0;
                }
            return 1;
        }
        if (n==1){
            for (int i=0; i<m; i++){
                if (obstacleGrid[i][0]==1)
                    return 0;
            }
            return 1;
        }

        for (int i=0; i<m; i++){
            if (obstacleGrid[i][0]==1){
                while (i < m){
                    obstacleGrid[i++][0] = 0;
                }
                break;
            }
            else
                obstacleGrid[i][0] = 1;
        }

        for (int i=1; i<n; i++){
            if (obstacleGrid[0][i]==1){
                while (i<n){
                    obstacleGrid[0][i++] = 0;
                }
                break;
            }
            else
                obstacleGrid[0][i] = 1;
        }

        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                if (obstacleGrid[i][j]==1)
                    obstacleGrid[i][j] = 0;
                else
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }
        return obstacleGrid[m-1][n-1];
    }
}
