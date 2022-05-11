package 代码块;

public class BlockTest {
    public static void main(String[] args) {
        String desc = Person.desc;
        Person p1=new Person();
        Person p3=new Person();
    }
}

class Person {
    String name;
    int age;
    static String desc = "我是人";


    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //代码块：初始化类、对象（静态代码块+static、非静态代码块）
    //静态代码块：类加载就执行
    static {
        System.out.println("我是静态代码块");
    }
    //非静态代码块：对象创建就执行（创建一个执行一次）
    {
        System.out.println("我是非静态代码块");
    }

    public void eat() {
        System.out.println("人吃饭");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}