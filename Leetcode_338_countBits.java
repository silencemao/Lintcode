package main.java;

/**
 * 给定一个数num，找出0，1，2...num 中这些数分别以二进制表示之后，每一个数中分别有多少个1
 * num=5
 * [0,1,1,2,1,2]
 * */
public class Leetcode_338_countBits {
    public static void main(String[] args){
        int num = 5;
        int[] result = countBits1(num);
        for (int n : result){
            System.out.println(n);
        }
    }

    public static int help(int num){
        int count = 0;
        while (num!=0){
            if ((num & 1)==1){
                count ++;
            }
            num = num>>1;
        }
        return count;
    }
    public static int[] countBits(int num){
        int[] result = new int[num+1];
        for (int i=0; i<=num; i++){
            result[i] = help(i);
        }
        return result;
    }

    /**
     * https://leetcode.com/problems/counting-bits/discuss/270693/Intermediate-processsolution-for-the-most-voted-solution-i.e.-no-simplificationtrick-hidden
     * 如果一个数是偶数 则二进制表示的最后一位是0 所以res[i] = res[i>>1];
     * 如果一个数是奇数 则二进制表示的最后一位是1 所以res[i] = res[i-1] + 1;
     * */
    public static int[] countBits1(int num){
        int[] result = new int[num+1];
        result[0] = 0;
        for (int i=1; i<=num; i++){
            if ((i & 1)==0){   // 偶数
                result[i] = result[i>>1];
            }
            else {
                result[i] = result[i-1] + 1;
            }
        }
        return result;
    }

}
