package 权限修饰符2;//和 权限修饰符 包一起看

import 权限修饰符.Order;

public class OrderTest {
    public static void main(String[] args) {
        Order o=new Order();
        o.orderPublic=1;
        o.methodPublic();

        //不同包的普通类，不能调用权限为private、缺省、protected权限的属性 方法
        //o.orderPrivate=3;
        //o.orderProtected=4;
        //o.methodProtected();
    }

    public void show(Order o){
        o.orderPublic=1;
        //o.orderProtected=3;
    }
}
