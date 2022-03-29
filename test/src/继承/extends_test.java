package 继承;

public class extends_test {
    public static void main(String[] args) {
        People p = new People();
        p.getWeight();

        Student s = new Student(2, 3, 5);
        s.getGrade();  //子类Student继承父类People的属性、方法（包括权限修饰符也继承）
        s.getWeight();
    }
}
