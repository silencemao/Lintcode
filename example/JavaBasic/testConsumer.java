package main.java.example.JavaBasic;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://www.cnblogs.com/snowInPluto/p/5981400.html
public class testConsumer {
    public static void main(String[] args) {
        testAccept();
        testAddThen();
        testMap();
        testFilter();
        testFlatMap();
        testmaxMin();
    }

    /**
     * 函数式编程，传入一个数据，然后产生一个结果，但是不返回任何数据
     * consumer 消费者模式
     * 生成一个消费实例 function，Consumer<xx> func，  xx代表需要传入的数据类型
     * 执行func.accept(xx类型的data) func对其进行处理
     * */
    public static void testAccept() {
        Consumer<Integer> display = a -> System.out.println(a);
        display.accept(10);

        // 2倍函数
        Consumer<List<Integer>> modify = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) * 2);
            }
        };

        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3);
        // 传入数据
        modify.accept(list);
        // 打印数据函数
        Consumer<List<Integer> >
                dispList = list1 -> list1.forEach(a -> System.out.print(a + " "));
        // 传入数据
        dispList.accept(list);
        System.out.println();
    }

    /**
     * andThen函数，
     * Consumer<xx> func
     * Consumer<xx> func1
     * func.addThen(func1).accept(data)
     * first
     * func.accept(data)
     * then
     * func1.accept(data)
     * */
    public static void testAddThen() {
        // Consumer to multiply 2 to every integer of a list
        Consumer<List<Integer> > modify = list -> {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };

        // Consumer to display a list of integers
        Consumer<List<Integer> >
                dispList = list -> list.forEach(a -> System.out.print(a + " "));

        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);

        // using addThen()
        modify.andThen(dispList).accept(list);
        System.out.println();
    }

    /**
     * map实现对集合中的所有数据进行统一的操作，代替for循环挨个遍历
     * */
    public static void testMap() {
        List<String> collected = Stream.of("a", "b", "hello").map(String::toUpperCase).collect(Collectors.toList());
        collected.forEach(System.out::println);
    }
    /**
     * filter 对集合中的数据进行过滤，将结果存放至新的list中，对原始数据没有影响
     *
     * */
    public static void testFilter() {
        List<String> collected = new ArrayList<>();
        collected.add("10"); collected.add("1abc"); collected.add("mnq"); collected.add("10h");
        List<String> result = collected.stream().filter(string -> Character.isDigit(string.charAt(0))).collect(Collectors.toList());
//        System.out.println(result.toString());
        result.forEach(System.out::println);
    }
    /**
     * flatMap 合并集合
     * */
    public static void testFlatMap() {
//        List<Integer> together = Stream.of()
        Integer[][] collected = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Stream<Integer> result = Arrays.stream(collected).flatMap(x -> Arrays.stream(x));
        result.forEach(x -> System.out.println(x));
    }

    public static void testmaxMin() {
        System.out.println("test max min");
//        List<Integer> collected = Arrays.asList(1, 20, 3, 9, 30);  // 这种初始化方法,collected的size固定了,不能再add,remove了
//        collected.remove(collected.size()-1);

        List<Integer> collected = new ArrayList<>(Arrays.asList(1, 20, 3, 9, 30));  // 这个list的size不固定，可以增加/删除
        collected.add(50);
        collected.forEach(x -> System.out.println(x));
        int maxInt = Collections.max(collected);
        int minInt = Collections.min(collected);
        System.out.println(maxInt);
        System.out.println(minInt);
    }
}
