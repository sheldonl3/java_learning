package 反射;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class 调用运行时类的结构 {
    //操作运行时类的属性 public
    @Test
    public void testField() throws Exception {
        Class clazz = Person.class;
        //创建运行时对象
        Person p =(Person) clazz.newInstance();
        //获取指定的属性，只能是public(通常不用这种方法)
        Field name = clazz.getField("name");
        //设置某个对象的属性值
        name.set(p,"silai");
        //获取属性值
        String n =(String) name.get(p);
        System.out.println(n);
    }

    //操作运行时类的属性 private ！！
    @Test
    public void testField2() throws Exception {
        Class clazz = Person.class;
        //创建运行时对象
        Person p =(Person) clazz.newInstance();
        //获取指定的属性
        Field age = clazz.getDeclaredField("age");
        //保证属性可以访问，public也可以加
        age.setAccessible(true);
        //设置某个对象的属性值,用法：set(那个对象，值为多少)
        age.set(p,18);
        //获取属性值
        int n =(int) age.get(p);
        System.out.println(n);
    }

    //调用运行时类的方法！！
    @Test
    public void testField3() throws Exception {
        Class clazz = Person.class;
        //创建运行时对象（非静态方法，需要对象）
        Person p = (Person) clazz.newInstance();
        //获取指定的属性，用法：getDeclaredMethod（方法名，方法的型参列表）
        Method show_private = clazz.getDeclaredMethod("show_private", String.class);
        //保证方法可以访问
        show_private.setAccessible(true);
        //开始调用 ：invoke(调用对象，方法实参)，invoke返回值就是调用方法的返回值
        String res = (String) show_private.invoke(p, "asdf");
        System.out.println(res);

        Method show_des = clazz.getDeclaredMethod("show_des");
        show_des.setAccessible(true);
        show_des.invoke(null);//调用静态方法可以不写
    }

    //调用运行时类的构造器（一般用无参的newInstance，其他的不常用）
    @Test
    public void testField4() throws Exception {
        Class clazz = Person.class;
        //获取指定的构造器
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
        //保证可以访问
        declaredConstructor.setAccessible(true);
        //调用构造器创建运行时对象
        Person tom = (Person) declaredConstructor.newInstance("tom");
        System.out.println(tom);
    }
}
