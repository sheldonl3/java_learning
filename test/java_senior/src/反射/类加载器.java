package 反射;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class 类加载器 {

    @Test
    public void test(){
        //自定义类，用系统类加载器
        ClassLoader classLoader = 类加载器.class.getClassLoader();
        System.out.println(classLoader);
        //系统类加载器的getparent(),获取扩展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        //扩展类加载器的getparent()不能获取引导类加载器了
        //引导类加载器加载核心类库，无法加载自定义类

    }

    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();
        //读取配置文件方式一：默认路径是module
        //FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
        //FileInputStream fileInputStream = new FileInputStream("src\\jdbc.properties");//路径也可以改成src
        //pros.load(fileInputStream);

        //读取配置文件方式二：默认路径是src(tomcat用这个)
        ClassLoader classLoader = 类加载器.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(resourceAsStream);

        String user = pros.getProperty("user");
        String pass = pros.getProperty("password");
        System.out.println(user);
        System.out.println(pass);


    }
}
