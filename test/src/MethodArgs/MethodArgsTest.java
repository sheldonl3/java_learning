package MethodArgs;

public class MethodArgsTest {   //可变个数形参，使用方式=数组
    public static void main(String[] args) {
        MethodArgsTest methodtest = new MethodArgsTest();
        methodtest.ShowString(3, "asd", "wqerd", "tytyun");
    }

    public void ShowString(int r, String... args) { //可变个数形参声明在最后
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
    }
}
