package Super;

public class Student extends People {
    String major;
    int id = 1002;

    public Student(String major) {
        this.major = major;
        super.age = 3;//用super调用父类属性
    }

    public Student(String major, int age, String name) {
        super(name, age);//用super调用父类构造器
        this.major = major;
    }

    public void eat() {
        super.eat(); //用super调用父类方法
        System.out.println("eat in student");
    }
}
