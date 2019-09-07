package main.java;

/***
 * 矩形区域覆盖的数的
 * 和
 */
public class Leetcode_304_NumMatrix {
    public static void main(String[] args){
        int[][] matrix = {
                {},
                {},
                {},
                {},
                {}
        };

        NumMatrix1 numMatrix = new NumMatrix1(matrix);

        int row1 = 1, col1 = 2, row2 = 2, col2 = 4;
        int result = numMatrix.sumRegion(row1, col1, row2, col2);
        System.out.println(result);
    }
}

class NumMatrix{
    private int[][] matrix;
    public NumMatrix(int[][] matrix){

        if (matrix.length > 0 && matrix[0].length > 0){
            for (int row=1; row<matrix.length; row++){
                matrix[row][0] += matrix[row-1][0];
            }
            for (int col=1; col<matrix[0].length; col++){
                matrix[0][col] += matrix[0][col-1];
            }
            for (int row=1; row<matrix.length; row++){
                for (int col=1; col<matrix[0].length; col++){
                    matrix[row][col] = matrix[row][col] + matrix[row-1][col] + matrix[row][col-1] - matrix[row-1][col-1];
                }
            }
        }
        this.matrix = matrix;

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (this.matrix.length > 0 && this.matrix[0].length > 0){
            if (row1==0 && col1==0) {
                return this.matrix[row2][col2];
            }
            if (row1==0) {
                return this.matrix[row2][col2] - this.matrix[row2][col1-1];
            }
            if (col1==0){
                return this.matrix[row2][col2] - this.matrix[row1-1][col2];
            }
            int left = Math.max((col1 - 1), 0);
            int up = Math.max(row1-1, 0);
            return this.matrix[row2][col2] - this.matrix[row2][left] - this.matrix[up][col2] + this.matrix[row1-1][col1-1];
        }
        return 0;
    }
}

class NumMatrix1{

    private int[][] sums;
    private int row=0, col=0;
    public NumMatrix1(int[][] matrix){
        this.row = matrix.length;
        this.col = this.row > 0 ? matrix[0].length : 0;
        sums = new int[row+1][col+1];
        for (int i=1; i<=row; i++){
            for (int j=1; j<=col; j++){
                sums[i][j] = matrix[i-1][col-1] + sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sums.length==1) return 0;
        if (sums[0].length==1) return 0;
        return sums[row2+1][col2+1] - sums[row2+1][col1] - sums[row1][col2+1] + sums[row1][col1];
    }

}
