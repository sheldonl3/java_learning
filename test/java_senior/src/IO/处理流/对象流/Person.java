package IO.处理流.对象流;

import java.io.Serializable;

/*
对象需要序列化
1.实现接口Serializable（无方法）
2.提供全局常量 serialVersionUID
 */
public class Person implements Serializable {
    public String name;
    public int age;

    private static final long serialVersionUID = -4787907546L;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
