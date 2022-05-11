package 权限修饰符;

public class orderTest {
    public static void main(String[] args) {
        Order o=new Order();
        o.orderPublic=1;
        o.orderDefault=3;
        o.orderProtected=3;

        o.methodDefault();
        o.methodProtected();
        o.methodDefault();

        //同一个包中其他类，不可以调用order类中私有的属性 方法
        //o.orderPrivate=3;
        //o.methodPrivate();
    }
}
