package 多线程;

import java.util.concurrent.locks.ReentrantLock;

public class 线程同步 {
    public static void main(String[] args) {
        //Window w = new Window();
        //Window2 w = new Window2();
        Window3 w = new Window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

//3个窗口卖100张票，出现了错票问题，需要同步机制解决线程安全问题
//方式一：同步代码块
class Window implements Runnable {
    private int tickets = 100;

    Object o = new Object();//当🔓，多个线程只有一个🔓  ，static对象使用类本身当锁

    @Override
    public void run() {
        while (true) {
            synchronized (o) {  //synchronized (this) 可以直接用this,继承thread多线程时，慎用
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票：id=" + tickets);
                    tickets--;
                } else {
                    break;
                }
            }
        }
    }
}

//方式二：同步方法
class Window2 implements Runnable {
    private int tickets = 100;

    @Override
    public void run() {
        while (true) {
            sell();
        }
    }

    private synchronized void sell() {//默认使用this当锁，static方法使用类本身当锁
        if (tickets > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票：id=" + tickets);
            tickets--;
        }
    }
}

//方式三：lock
class Window3 implements Runnable {
    private int tickets = 100;
    //创建lock
    private ReentrantLock lock = new ReentrantLock(true);//true:先来后到

    @Override
    public void run() {
        while (true) {
            try {
                //锁定
                lock.lock();
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票：id=" + tickets);
                    tickets--;
                } else {
                    break;
                }
            }finally {
                //解锁
                lock.unlock();
            }
        }
    }
}