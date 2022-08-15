package 新特性.java8新特性.stream_api;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Stream API对集合数据进行操作，类似sql进行数据查询,主要是计算
为什么用：nosql数据库需要在java层面去处理数据，需要用到stream api
注意：stream不会存储数据；不会改变源对象；是延迟执行的（终止操作发生后才执行）
Stream 流程：
创建stream ——> 中间操作 ——> 终止操作
 */

//创建stream
public class stream创建 {
    //通过集合
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        //用集合的方法创建
        Stream<Employee> employeeStream = employees.stream();//顺序流
        Stream<Employee> employeeStream1 = employees.parallelStream();//并行流
    }

    //通过数组
    @Test
    public void test2() {
        int[] arr =new int[]{1,2,3,4};
        //通过arrays的静态方法获取
        IntStream stream = Arrays.stream(arr);
    }

    //通过stream 的of()
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 3, 4, 5, 7);
    }


    //创建无限流
    @Test
    public void test4() {
        //需要中间操作limit的限制个数  foreach的终止操作输出结果
        Stream.iterate(0,t->t+4).limit(23).forEach(System.out::println);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}