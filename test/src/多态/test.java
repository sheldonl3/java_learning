package 多态;

import java.util.Random;

class Animal {
    public void eat() {
        System.out.println("animal eat");
    }
}

class Cat extends Animal {
    public void eat() {
        System.out.println("cat eat");
    }
}

class Dog extends Animal {
    public void eat() {
        System.out.println("dog eat");
    }
}

class Sheep extends Animal {
    public void eat() {
        System.out.println("sheep eat");
    }
}

public class test {
    public static void main(String[] args) {
        int key = new Random().nextInt(3);
        System.out.println(key);
        Animal animal = getAnimal(key);  //多态：父类引用指向子类对象
        animal.eat();                    //调用重写的方法，在运行期间 运行子类重写过的方法(动态绑定)
    }

    //定义为static 静态方法才能直接在类中调用，不需要new对象
    public static Animal getAnimal(int key) {
        switch (key) {
            case 0:
                return new Cat();
            case 1:
                return new Dog();
            default:
                return new Sheep();
        }
    }
}


