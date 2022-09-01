package 新特性.java9新特性;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 集合工厂方法 {
    //java8创建只读集合，不能写入
    @Test
    public void test(){
        List<String> arrayList = new ArrayList<>();
        arrayList.add("aswq让我软弱");
        arrayList.add("烧热");
        List<String> stringList = Collections.unmodifiableList(arrayList);
        //stringList.add("sad");返回的对象只读，不能写

        System.out.println(stringList);
    }

    //java9创建方法
    @Test
    public void test1(){
        List<Integer> list = List.of(1, 34, 5, 3, 2);
        //list.add(4);
        System.out.println(list);
    }
}
