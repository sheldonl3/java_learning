package 构造器;

public class Girl {

    private String name;
    private int age;

    public Girl(){
    }

    public Girl(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void marry(Boy boy) {
        System.out.println("I will," + boy.getName());
        boy.marry(this); //使用this，代表当前正在创建的类的对象
    }

}
