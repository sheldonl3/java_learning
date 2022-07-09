package 反射;

public class Person {
    private int age;
    public String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private Person(String name) {
        this.age = 5;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void show() {
        System.out.println("this is person class ");
    }

    private String show_private(String ss) {
        System.out.println("this is private method whith :" + ss);
        return "i am return";
    }

    private static void show_des() {
        System.out.println("static method for person class ");
    }
}
