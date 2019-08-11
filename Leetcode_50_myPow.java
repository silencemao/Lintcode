package main.java;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * 幂次方
 * */
public class Leetcode_50_myPow {
    public static void main(String[] args){
        double x = 2;
        int n = Integer.MIN_VALUE;
        System.out.println(myPow(x, n));
        System.out.println(myPow1(x, n));
        System.out.println(myPow2(x, n));
    }

    public static double myPow(double x, int n){
        if (n==0) return 1;
        if (n==Integer.MIN_VALUE && x > 1) return 0.0;
        if (n < 0){
            x = 1/x;
            n = -n;
        }
        return (n%2==0) ? myPow(x*x, n/2) : x * myPow(x*x, n/2);
    }

    public static double myPow1(double x, int n){
        if (n==0) return 1;
        if (n==Integer.MIN_VALUE && x > 1) return 0.0;
        if (n < 0){
            x = 1/x;
            n = -n;
        }
        if ((n & 1)==0){
            return myPow1(x*x, n/2);
        }
        else {
            return x * myPow1(x*x, n/2);
        }
    }

    /**
     * N=9 二进制 1001
     * x^9 = x^(1001) = x^(1*2^3 + 0*2^2 + 0*2^1 + 1*2*0) = x^(8+1) = x^8 * x^1
     *
     * */
    public static double myPow2(double x, int n){
        if (n==0) return 1;
        double res = 1;
        long absN = Math.abs((long)n);
        while (absN > 0){
            if ((absN & 1)==1)
                res *= x;
            absN >>= 1;
            x *=x;
        }
        return n < 0 ? 1/res : res;
    }
}
