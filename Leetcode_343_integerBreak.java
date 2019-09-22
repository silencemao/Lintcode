package main.java;

/**
 * 给定一个数n，拆分成至少两个正数的组合，返回组合数的乘积，使乘积最大
 * 跟剪绳子类似
 * */
public class Leetcode_343_integerBreak {
    public static void main(String[] args) {
        int n =  11;
        int result = integerBreak(n);
        System.out.println(result);
    }

    /**
     * 数字均可拆分成 2和3
     * 但是全部拆分成 2 不如拆分成2和3的组合得到乘积最大，比如 2*2*2 < 3*3
     * 所以我们优先拆分成3 剩下的数字只能是1 或者 2，如果余数为1，则可以拿出一个3组合生成两个2 1*3 < 2*2
     *
     * https://leetcode.com/problems/integer-break/discuss/80721/Why-factor-2-or-3-The-math-behind-this-problem.
     * */
    public static int integerBreak(int n) {
        if (n==2) return 1;
        if (n==3) return 2;
        int numOfTwo = 0, numOfThree = 0;
        numOfThree = n / 3;
        n = n - 3 * numOfThree;

        if (n == 1) {
            numOfTwo = 2;
            numOfThree -= 1;
        }
        else if (n==2){
            numOfTwo = 1;
        }

        return (int) (Math.pow(2, numOfTwo) * Math.pow(3, numOfThree));
    }

    public static int integerBreak1(int n) {
        if (n==2) return 1;
        if (n==3) return 2;
        int product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        product *= n;
        return product;
    }
}
