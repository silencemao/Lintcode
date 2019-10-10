package main.java.JavaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class testConsumer {
    public static void main(String[] args) {
        testAccept();
        testAddThen();
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
    }
}
