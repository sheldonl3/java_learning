package 泛型.自定义泛型类;

import java.util.ArrayList;
import java.util.List;

//自定义泛型类
public class Order<T> {
    String orderName;
    int orderId;
    T orderT;

    public Order() {
    }

    ;

    public Order(String orderName, int orderId, T orderT) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    //静态方法不能使用泛型
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }

    //泛型方法：方法中有泛型结构，与泛型类没有关系
    public <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }

}
