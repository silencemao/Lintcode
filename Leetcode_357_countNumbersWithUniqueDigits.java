package main.java;

/**
 * 给定一个数n，返回 0 <= x <10^n之间的无重复数字的个数，
 * n=0 1
 * n=1 10
 * n=2 91
 * */
public class Leetcode_357_countNumbersWithUniqueDigits {
    public static void main(String[] args) {
        int n = 2;
        int result = countNumbersWithUniqueDigits(n);
        System.out.println(result);
        System.out.println(countNumBersWithUniqueDigits1(2));
    }
    /**
     * 次高位有9个选择，次次高位有8个选择，向后依次类推
     * i代表当前最高位后面有i位
     * */
    public static int help(int n, int i) {
        if (i==0) {
            return 1;
        }
        else {
            return n * help(n - 1, i - 1);
        }
    }
    public static int countNumbersWithUniqueDigits(int n) {
        int sum = 1;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                sum += 9 * help(9, i);  // 括号外面的9代表最高位，括号里面的9代表次高位 i代表最高位后面还有几位，即分10-99 100-999
            }
        }

        return sum;
    }

    public static int countNumBersWithUniqueDigits1(int n) {
        if (n == 0)     return 1;

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }
}
