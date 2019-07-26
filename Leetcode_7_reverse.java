package main.java;

/**
 * 数字反转，输入整数x，返回x反转之后的数字
 * x的范围是带符号的整数
 * 比较是否溢出的地方要注意，不能直接result和maxvalue/minvalue比较，应该和它们除以10之后比较
 * */
public class Leetcode_7_reverse {
    public static void main(String[] args){
        TEST(  123,  321);
        TEST( -123, -321);
        TEST( -100,   -1);
        TEST( 1002, 2001);
        //big integer
        TEST( 1463847412,  2147483641);
        TEST(-2147447412, -2147447412);
        TEST( 2147447412,  2147447412);
        //overflow
        TEST( 1000000003, 0);
        TEST( 2147483647, 0);
        TEST(-2147483648, 0);

    }

    public static void TEST(int x, int rx){
        boolean flag = x == reverse(rx);
        System.out.println(x + " ======> " + reverse(x) + " " + flag);
    }
    public static int reverse(int x){
        final int maxValue = 2147483647;
        final int minValue = -2147483648;

        int result = 0;
        while (x != 0){
            int tmp = x % 10;
            if (result > (maxValue / 10) || result < (minValue / 10)){
                return 0;
            }
            result = result * 10 + tmp;
            x /= 10;
        }
        return result;
    }
}
