package 泛型.通配符;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class 通配符 {
    @Test
    public void test() {
        List<Object> l1 = Arrays.asList(2, 42, 4);
        List<String> l2 = null;
        List<?> list = null;

        list = l1;
        list = l2;
        print(l1);
    }

    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    //有限制条件的通配符
    @Test
    public void test2() {
        //  可以当 <= person泛型的父类
        List<? extends Person> list1 = null;
        //  可以当 >= person泛型的父类
        List<? super Person> list2 = null;

        List<Student> l3 = new ArrayList<Student>();
        List<Person> l4 = new ArrayList<Person>();
        List<Object> l5 = new ArrayList<Object>();

        list1 = l3;
        list1 = l4;
        //list1=l5;

        //list2=l3;
        list2 = l4;
        list2 = l5;

        //读取
        list1 = l4;
        Person p = list1.get(2);

        list2 = l4;
        Object o = list2.get(32);

        //写入
        //list1.add(new Student());
        list2.add(new Student());
        list2.add(new Person());

    }

}

