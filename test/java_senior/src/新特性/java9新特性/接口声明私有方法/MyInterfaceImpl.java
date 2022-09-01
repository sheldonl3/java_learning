package 新特性.java9新特性.接口声明私有方法;

public class MyInterfaceImpl implements MyInterface {
    @Override
    public void methodAbstract() {

    }

//    @Override
//    public void methodDefault() {
//        System.out.println("重写默认方法");
//    }


    public static void main(String[] args) {
        MyInterface.methodStatic();
        MyInterfaceImpl myInterface = new MyInterfaceImpl();
        myInterface.methodDefault();
        //myInterface.methodPrivate();实现类不能调用接口的private方法
    }
}
