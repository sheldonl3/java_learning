package Super;

public class People {
    String name;
    int age;
    int id = 1001;

    public People() {
    }

    public People(String name) {
        this.name = name;
    }

    public People(String name, int age) {
        this(name);
        this.age = age;
    }

    public void eat() {
        System.out.println("eat in people");
    }
}
