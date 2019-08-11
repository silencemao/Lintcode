package main.java;

import com.sun.tools.javac.code.Attribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestChange {
    public static void main(String[] args){
        int a = 1, b = 2;
        System.out.println("before change num " + a + "\t" + b);
        change(a, b);
        System.out.println("after change num  " + a + "\t" + b);

        int[] arr = {4, 5};
        System.out.println("before change arr " + arr[0] + "\t" + arr[1]);
        change(arr);
        System.out.println("after change arr  " + arr[0] + "\t" + arr[1]);

        String str = "123";
        System.out.println("before change str " + str);
        change(str);
        System.out.println("after change str  " + str);

        String[] strs = {"1", "2" , "3"};
        System.out.println("before change strs " + Arrays.toString(strs));
        change(strs);
        System.out.println("after change strs  " + Arrays.toString(strs));

        List<Integer> list = new ArrayList<>();
        System.out.println("before change list " + list.toString());
        change(list);
        System.out.println("after change list  " + list.toString());

    }

    public static void change(int a, int b){
        a = 10;
        b = 10;
    }

    public static void change(int[] nums){
        nums[0] = 10;
        nums[1] = 10;
    }

    public static void change(String str1){
        str1 = "change";
    }

    public static void change(String[] str){
        str[0] = "changed!";
    }
    public static void change(List<Integer> list){
        list.add(10);
        list.add(19);
    }


}
