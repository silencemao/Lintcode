package main.java;

/**
 * 第n个丑数 丑数是指只能被2 3 5整除的正整数 1也是丑数
 * 求第n个丑数
 * 丑数只能被2 3 5三个数整除，用三个指针分别指向能被这三个数整除的位置，所以从第1个丑数开始分别与2 3 5相乘，取最小的那个数作为下一个丑数，
 * 然后更新指针的位置，每次都选一个最小的数最为下一个丑数
 * */
public class Leetode_264_nthUglyNumber {
    public static void main(String[] args){
        int n = 10;
        int result = nthUglyNumber(n);
        System.out.println(result);
    }

    public static int nthUglyNumber(int n){
        int[] uglyNum = new int[n];
        uglyNum[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int i = 1;
        while (i < n){
            int tmp = Math.min(Math.min(uglyNum[index2] * 2, uglyNum[index3] * 3), uglyNum[index5] * 5);
            uglyNum[i++] = tmp;
            if (uglyNum[index2] * 2 == tmp){
                index2++;
            }
            if (uglyNum[index3] * 3 == tmp){
                index3++;
            }
            if (uglyNum[index5] * 5 == tmp){
                index5++;
            }
        }
        return uglyNum[n-1];
    }
}
