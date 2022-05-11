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
    public void climb(){
        System.out.println("cat can climb");
    }
}

class Dog extends Animal {
    public void eat() {
        System.out.println("dog eat");
    }
    public void swim(){
        System.out.println("dog can swim");
    }
}

class Sheep extends Animal {
    public void eat() {
        System.out.println("sheep eat");
    }
    public void sheepCanDo(){
        System.out.println("sheepCanDo");
    }
}

public class test {
    public static void main(String[] args) {
        int key = new Random().nextInt(3);
        System.out.println(key);
        Animal animal = getAnimal(key);  //多态：父类引用指向子类对象
        animal.eat();                    //调用重写的方法，在运行期间 运行子类重写过的方法(动态绑定)
        instanceofTest(animal);
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

    //instanceof关键字
    //多态的父类引用无法调用子类特有的方法，可以通过向下转型（强制类型转换）后调用
    //向下转型，如果转错子类，则出现class cast exception异常，为了避免异常，使用Instanceof关键字在转换前进行判断可否转换
    public static void instanceofTest(Animal a){
        // ((Dog) a).swim();   不能未判断就转换使用
        if(a instanceof Dog){
            ((Dog) a).swim();
        } else if (a instanceof Cat) {
            ((Cat) a).climb();
        }else {
            ((Sheep) a).sheepCanDo();
        }
    }
}


