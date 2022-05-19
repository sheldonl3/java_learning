package 常用类;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringTest {
    @Test
    public void test1() {
        String s1 = "asd";
        String s2 = "asd";
        s1 = "ssss";

        System.out.println(s1 + "...." + s2);

        String replace = s1.replace("s", "ds");//string在常量池中，不可变性
        System.out.println(replace + "..." + s1);

    }

    //定义
    @Test
    public void test2() {
        String s1 = "javaee";
        String s2 = new String("javaee");  //new的对象指向堆，再指向常量池

    }

    //常用方法
    @Test
    public void Methods() {
        String s1 = "helloworld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(4));
        System.out.println(s1.isEmpty());

        String s2 = s1.toUpperCase();
        System.out.println(s2);
        System.out.println(s2.equals(s1));
        System.out.println(s2.equalsIgnoreCase(s1));

        String s3 = "   fer r er    r   ";
        String trim = s3.trim();//去除首尾空格
        System.out.println("------" + s3 + "--------");
        System.out.println("------" + trim + "--------");

        String s4 = "abc";
        String s5 = "abd";
        System.out.println(s4.compareTo(s5));//比较大小

        String s6 = "我日尼玛";
        System.out.println(s6.substring(1));
        System.out.println(s6.substring(1, 3));

        System.out.println(s6.endsWith("玛"));
        System.out.println(s6.startsWith("日", 1));

        System.out.println(s1.contains(s6));//是否包含

        System.out.println(s3.indexOf("er"));//查找第一次出现索引
        System.out.println(s3.indexOf("er",11));
        System.out.println(s3.lastIndexOf("er"));

        String replace = s1.replace("h", "ewe");
        System.out.println(replace);

        String s8="hello?world?misaka";
        String[] strings=s8.split("\\?");
        for (int i = 0; i <strings.length ; i++) {
            System.out.println(strings[i]);

        }

    }

    //类型转化
    @Test
    public void change() throws UnsupportedEncodingException {
        String str="123";
        int num = Integer.parseInt(str);
        String str2 = String.valueOf(num);
        System.out.println(num + str2);

        //与char[]转换
        char[] charry = str.toCharArray();
        for (int i = 0; i <charry.length ; i++) {
            System.out.println(charry[i]);
        }
        String chastr = new String(charry);
        System.out.println(chastr);

        //与byte[]转换 ，字符集需要一致
        str="123阿斯顿";
        byte[] bytes = str.getBytes();//默认utf-8 编码
        System.out.println(Arrays.toString(bytes));
        byte[] gbks = str.getBytes("gbk");//gbk
        System.out.println(Arrays.toString(gbks));

        String s = new String(bytes);//解码
        System.out.println(s);
        String gbk = new String(gbks,"gbk");
        System.out.println(gbk);
    }

}
