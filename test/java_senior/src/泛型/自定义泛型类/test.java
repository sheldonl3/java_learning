package 泛型.自定义泛型类;

import org.junit.jupiter.api.Test;

import java.util.List;

public class test {
    @Test
    public void test1() {
        //泛型类不指明泛型类，默认是object类型
        Order order = new Order();
        order.setOrderT("asd");

        Order<String> order1 = new Order<>("aa", 1001, "misaka");

    }


    @Test
    public void subtest() {
        subOrder sub1 = new subOrder();
        sub1.setOrderT(23);

        subOrder1<String> sub2 = new subOrder1();
        sub2.setOrderT("23");
    }

    //泛型方法
    @Test
    public void modtest() {
        Order<String> order=new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        List<Integer> list=order.copyFromArrayToList(arr);
        System.out.println(list);
    }
}
