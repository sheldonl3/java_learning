package 集合;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(34);
        list.add(47);
        list.add(56);
        list.add(90);
        list.add(90);
        list.add(456);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

        Collections.shuffle(list);//随机化
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        Collections.swap(list, 1, 2);
        System.out.println(list);

        System.out.println(Collections.frequency(list, 90));

    }

    //copy
    @Test
    public void test2() {
        List list = new ArrayList();
        list.add(34);
        list.add(47);
        list.add(56);
        list.add(90);
        list.add(456);
        System.out.println(list);


        List list2 = Arrays.asList(new Object[list.size()]);//目的list的元素个数大于等于来源list
        Collections.copy(list2, list);
        System.out.println(list2);
    }

    //变成线程安全的
    @Test
    public void test3() {
        List list = new ArrayList();
        List list1 = Collections.synchronizedList(list);

    }
}
