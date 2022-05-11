package Static;

public class test {
    public static void main(String[] args) {
        Chinese.nation="ch";
        System.out.println(Chinese.nation);
        Chinese.show();
    }
}

class Chinese{
    static String nation;       //static修饰类中静态变量，与对象无关，类加载后可以直接调用
    int age;
    String name;

    public static void show(){  //static修饰类中静态方法，类加载后可以直接调用
        System.out.println("i am Chinese");
        // age=123;             //静态方法内部只能用静态变量
        nation="chinese";
    }
}