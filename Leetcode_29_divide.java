package main.java;
/**
 * 两数相除
 * */
public class Leetcode_29_divide {
    public static void main(String[] args){
        int dividend = -2147483648;
        int divisor = -1;
        System.out.println(divide(dividend, divisor));
    }
    public static int divide(int dividend, int divisor) {
        final int maxValue = 2147483647;
        final int minValue = -2147483648;
        if (dividend==0) return 0;
        if (dividend==minValue && divisor==-1) return maxValue;

        int res = 0, x = 0;
        boolean flag = (dividend>0) == (divisor>0);

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while (dividend-divisor >= 0){   // dividend >= divisor 就不对
            for (x=0; dividend-(divisor << x << 1)>=0; x++);
            res += 1<<x;
            dividend -= divisor<<x;
        }
        return flag ? res : -1*res;
    }

    public static int divide1(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (A > 0) == (B > 0) ? res : -res;
    }
}
