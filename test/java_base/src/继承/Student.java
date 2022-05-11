package 继承;

public class Student extends People {
    private int grade;

    public Student() {
    }

    public Student(int height, int weight, int grade) {
        this.grade = grade;
        this.height = height;
        this.weight = weight;
    }

    public int getGrade() {
        System.out.println("my grade is " + grade);
        return grade;
    }
}
