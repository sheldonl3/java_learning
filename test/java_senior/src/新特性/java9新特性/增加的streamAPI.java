package 新特性.java9新特性;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class 增加的streamAPI {
    //takewhile   dropWhile
    @Test
    public void test() {
        List<Integer> list = Arrays.asList(23, 45, 23, 6, 3, 87, 6554, 3, 65);
        //takewhile() 返回从开头的按照制定规则的尽量多的元素（遇到第一个不满足的就结束，后面的不考虑）
        //list.stream().takeWhile(num -> num < 50).forEach(System.out::println);
        //与takewhile 相反
        list.stream().dropWhile(num -> num < 60).forEach(System.out::println);
    }

    //null元素
    @Test
    public void test2() {
        //of() 参数可以有null,但是不能只有一个null
        Stream<? extends Serializable> stream = Stream.of(2, 4, "345tr", null);
        stream.forEach(System.out::println);

        //ofnullable方法的参数可以为单个null
        Integer i = 0;
        i = null;
        Stream<Integer> i1 = Stream.ofNullable(i);
        System.out.println(i1.count());
    }

    //iterate
    @Test
    public void test3() {
        //iterate 的java8无限流
        //Stream.iterate(0,x->x+2).limit(20).forEach(System.out::println);

        //java9中重载加入了判断条件
        Stream.iterate(0, x -> x < 80, x -> x + 3).forEach(System.out::println);
    }

    //optional类加了stream方法
    @Test
    public void test4() {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("ret");
        list.add("dsfe");

        Optional<List<String>> optionalStringList = Optional.ofNullable(list);
        Stream<List<String>> listStream = optionalStringList.stream();
        listStream.flatMap(x -> x.stream()).forEach(System.out::println);
    }
}
