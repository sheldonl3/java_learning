package 多线程;

public class ThreadMethodTest {
    public static void main(String[] args) {
        MyThread2 t = new MyThread2("自线程");
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();

        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getPriority() + ": " + i);
            }
//            if (i == 20) {
//                //t.yield();//释放当前cpu执行权
//                try {
//                    t.join();//让main线程阻塞，运行t线程，直到t结束以后再运行main线程
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//          }
        }
        //System.out.println(t.isAlive());//判断线程是否存活
    }
}

class MyThread2 extends Thread {
    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(MAX_PRIORITY);
        for (int i = 0; i < 10; i++) {
//            if (i % 2 == 0) {
//                try {
//                    sleep(1000);//当前线程睡眠1s
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//               }
//                System.out.println(getName() + ": " + getPriority() + ":" + i);
//            }
            System.out.println(getName() + ": " + getPriority() + ":" + i);
        }
    }
}