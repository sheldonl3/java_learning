package 多线程;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();//start方法：1启动新线程 2.调用新线程的run()，不能直接调run()

        MyThread t2 = new MyThread();//需要创建多个对象，以运行多个线程
        t2.start();

        new Thread() {//thread的匿名子类的方式
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "  " + i);
                    }
                }
            }
        }.start();

        //主线程
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "  " + i);
            }
        }

        //runnable接口线程
        //把接口实现类变量赋值给thread变量，run()
        MyThread1 myThread1 = new MyThread1();
        Thread thread = new Thread(myThread1);
        thread.start();

        Thread thread2 = new Thread(myThread1);//公用myThread1
        thread2.run();
    }
}

//多线程创建方式1：继承
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "  " + i);
            }
        }
    }
}

//多线程创建方式2:实现runnable接口
class MyThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "  " + i);
            }
        }
    }
}