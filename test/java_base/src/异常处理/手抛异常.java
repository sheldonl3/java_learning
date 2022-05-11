package 异常处理;

public class 手抛异常 {
    public static void main(String[] args) {
        Student s = new Student();
        s.register(-332);
        s.toString();
    }


}

class Student {
    private int id;

    public void register(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            //手抛异常:运行时异常不用处理 编译不报错
            //throw new RuntimeException("数据非法");
            throw new MyException("MyException");
        }

    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + '}';
    }
}
