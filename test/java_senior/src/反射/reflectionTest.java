package 反射;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class reflectionTest {
    //类的标准使用方法
    @Test
    public void example_method() {
        Person p = new Person();
        p.show();
        p.setAge(23);
        //p.show_private();
    }

    //反射使用方法
    @Test
    public void reflection_test() throws Exception {
        Class c = Person.class;
        //1.使用反射创建对象
        /*
        都可以创建对象，建议还是直接new
        在编译的时候不能确定造什么对象，才用反射
         */
        Constructor cons = c.getConstructor(int.class, String.class);
        Object misaka = cons.newInstance(12, "Misaka");
        Person Misaka = (Person) misaka;
        System.out.println(misaka);

        //2.调用对象的属性，方法
        Field name = c.getDeclaredField("name");
        name.set(Misaka, "misaka");
        System.out.println(Misaka);
        Method show = c.getDeclaredMethod("show");
        show.invoke(Misaka);

        //3.调用对象的私有属性，方法
        Constructor cons1 = c.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person sante = (Person) cons1.newInstance("sante");
        System.out.println(sante);

        Field age = c.getDeclaredField("age");
        age.setAccessible(true);
        age.set(sante, 12);
        System.out.println(sante);

        Method show_private = c.getDeclaredMethod("show_private", String.class);
        show_private.setAccessible(true);
        String res = (String) show_private.invoke(sante, "asd");//返回值
        System.out.println(res);
    }

    //获取class实例的方式！！
    @Test
    public void get_reflect() throws ClassNotFoundException {
        //方式一:使用运行时类的属性（.class）
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二:使用运行时类的对象，调用getclass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：调用class的静态方法：forName(string path)
        Class clazz3 = Class.forName("反射.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);

        //方式四：使用类加载器：classloader(了解)
        ClassLoader classLoader = reflectionTest.class.getClassLoader();
        Class class4 = classLoader.loadClass("反射.Person");
        System.out.println(class4);

    }
}
