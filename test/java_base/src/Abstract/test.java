package Abstract;

public class test {
    public static void main(String[] args) {
        Manager m = new Manager("misaka", 1, 20000, 324222);
        m.work();
        Employee e = m;//也可以多态
        e.work();

        //抽象类的匿名子类的对象
        Employee e1 = new Employee() {
            @Override
            public void work() {
                System.out.println("employee类的匿名子类对象");
            }
        };
        e1.work();


        //抽象类的匿名子类的匿名对象
        work(new Employee() {
            @Override
            public void work() {
                System.out.println("employee类的匿名子类的匿名对象");
            }
        });
    }

    public static void work(Employee e) {
        e.work();
    }
}
