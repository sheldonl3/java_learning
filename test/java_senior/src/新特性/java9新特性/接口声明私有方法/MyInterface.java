package 新特性.java9新特性.接口声明私有方法;

public interface MyInterface {
    //必实现
    void  methodAbstract();

    //直接用
    static void methodStatic(){
        System.out.println("接口中的静态方法");
    }

    //可选重写
    default void methodDefault(){
        System.out.println("接口的默认方法");
        methodPrivate();
    }

    //jdk9中可以在接口中有私有方法
    private void methodPrivate(){
        System.out.println("jdk9中可以在接口中有私有方法");
    }

}
