package Abstract;

public class Manager extends Employee{
    private double bonus;

    public Manager(double bonus){
        super();
        this.bonus=bonus;
    }

    public Manager(String name, int id, double salary,double bonus) {
        super(name,id,salary);
        this.bonus=bonus;
    }

    //继承抽象类，需要重写抽象方法
    @Override
    public void work() {
        System.out.println("管理员工");
    }
}
