package main.java;

/**
 * 是否为丑数
 * */
public class Leetcode_263_isUgly {
    public static void main(String[] args){
        int n = 7;
        System.out.println(isUgly(n));
    }
    public static boolean isUgly(int num) {
        if (num < 1) return false;
        while (num%2 == 0){
            num /= 2;
        }
        while (num%3 == 0){
            num /= 3;
        }
        while (num%5 == 0){
            num /= 5;
        }
        return num==1;
    }
}
