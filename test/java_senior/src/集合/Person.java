package 集合;

import java.util.Objects;

public class Person implements Comparable{
    private int age;
    public  String name;

    public Person(int age, String name) {
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() && Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName());
    }


    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person p = (Person) o;
            int compare = this.name.compareTo(p.name);
            if(compare!=0){
                return compare;
            }else {
                return Integer.compare(this.age,p.getAge());
            }
        }else {
            throw new RuntimeException("输入类型错误");
        }
    }
}
