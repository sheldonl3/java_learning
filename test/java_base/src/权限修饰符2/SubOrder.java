package 权限修饰符2;

import 权限修饰符.Order;

public class SubOrder extends Order {
    public void method(){
        orderProtected=1;
        orderPublic=2;

        //不同包的子类中，不能调用权限为private和缺省的属性 方法
        //orderDefault=3;
        //methodDefault();
    }
}
