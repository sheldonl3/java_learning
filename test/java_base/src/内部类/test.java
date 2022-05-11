package 内部类;

public class test {
    public static void main(String[] args) {
        //创建静态内部类
        Person.Dog dog = new Person.Dog();
        dog.show();

        //创建非静态内部类
        Person p = new Person("misaka");
        Person.Cat cat = p.new Cat("jiafei");
        cat.show();
        cat.NameTest("NameTest");
    }
}

class Person {
    String name;
    int age;

    public Person(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("人吃饭");
    }

    static class Dog {
        String name;
        int age;

        public void show() {
            System.out.println("人的狗");
        }
    }

    class Cat {
        String name;
        int age;

        public Cat(String name) {
            this.name = name;
        }

        public void show() {
            System.out.println("人的猫,非静态");
            eat();
        }


        public void NameTest(String name) {
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Person.this.name);
        }
    }
}


