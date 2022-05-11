package 设计模式;

public class 单例模式 {
    public static void main(String[] args) {
        Bank b1 = Bank.getBank();
        Bank b2 = Bank.getBank();
        System.out.println(b1 == b2);

        Order o1 = Order.getOrder();
        Order o2 = Order.getOrder();
        System.out.println(o1 == o2);

    }
}

//饿汉式
class Bank {
    //1.私有化构造器
    private Bank() {
    }

    //2.内部创建类的对象（静态的）
    private static Bank bank = new Bank();

    //3.提供公共静态方法，返回对象
    public static Bank getBank() {
        return bank;
    }
}

//懒汉式
class Order {
    //1.私有化构造器
    private Order() {
    }

    //2.内部创建类的对象（静态的,不用初始化）
    private static Order order = null;

    //3.提供公共静态方法，返回对象
    public static Order getOrder() {
        if (order == null) {
            order = new Order();
        }
        return order;
    }
}