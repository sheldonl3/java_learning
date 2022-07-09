package 反射;

import org.junit.jupiter.api.Test;

import java.util.Random;

//创建运行时类的对象！！
public class 创建运行时类的对象 {
    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        /*
        调用newInstance（）创建运行时类的对象，内部使用了空参构造器
        使用前提：
        1.运行时类有空参构造器
        2.有访问空参构造器的权限，public
         */
        Person obj = clazz.newInstance();
        System.out.println(obj);
    }

    //反射的动态性，运行时才知道造出什么对象
    @Test
    public void test1() {
        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num) {
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "反射.Person";
                break;
        }
        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Object getInstance(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }

}
