package 接口;

public class UsbTest {
    public static void main(String[] args) {
        Computer c=new Computer();
        //1.接口实现类的对象
        UDisk u= new UDisk();
        c.tranferData(u);

        //2.接口实现类的匿名对象
        c.tranferData(new Printer());

        //3.接口匿名实现类的对象
        USB phone=new USB() {
            @Override
            public void start() {
                System.out.println("手机开始使用");
            }

            @Override
            public void stop() {
                System.out.println("手机停止使用");
            }
        };
        c.tranferData(phone);

        //4.接口匿名实现类的匿名对象
        c.tranferData(new USB() {
            @Override
            public void start() {
                System.out.println("mp4停止使用");
            }

            @Override
            public void stop() {
                System.out.println("mp4停止使用");
            }
        });
        USB.Compare();
        u.Compare2();
    }
}

//使用 接口实现类
class Computer {
    public void tranferData(USB usb) {//接口使用的多态性
        usb.start();
        System.out.println("传输数据");
        usb.stop();
    }
}

interface USB {
    //内部只有全局常量和抽象方法
    public static final int id=0;
    void start();

    void stop();

    //jdk8特性：接口还可以定义静态方法(只能接口自己用，实现类拿不到)、默认方法
    public static void Compare(){
        System.out.println();
    }
    //默认方法可以在实现类中使用，如果和实现类的父类重名，则优先父类调用————>类优先原则
    public default void Compare2(){

    }

}

//接口的实现类
class UDisk implements USB {

    @Override
    public void start() {
        System.out.println("u盘开始使用");
    }

    @Override
    public void stop() {
        System.out.println("u盘停止使用");
    }
}


class Printer implements USB {

    @Override
    public void start() {
        System.out.println("打印机开始使用");
    }

    @Override
    public void stop() {
        System.out.println("打印机停止使用");
    }
}