package 包装类;

public class WrapperTest {
    public static void main(String[] args) {
        //基本数据类型转换为包装类
        Integer i = new Integer(1);
        Integer i2 = 2; //jdk5特性，自动装箱
        System.out.println(i + " " + i2);


        //包装类转换为基本数据类型:xxxValue()
        int n1 = i.intValue();
        int n2 = i2;//自动拆箱
        System.out.println(n1 + " " + n2);

        //基本数据类型、包装类转化为String
        int num1 = 10;
        String s1 = num1 + "";  //链接运算
        s1 = String.valueOf(num1);

        Integer n3 = 34;
        String s2 = String.valueOf(n3); //valueof()
        System.out.println(s1 + "" + s2);

        //String转化为基本数据类型、包装类
        String s4 = "1233";
        int num4 = Integer.parseInt(s4);//parsexxx()
        System.out.println(num4);
    }
}
