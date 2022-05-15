package 多线程;

public class 线程通信 {
    public static void main(String[] args) {
        Number n = new Number();

        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);

        t1.start();
        t2.start();
    }

}

//2个线程交替打印1-100
class Number implements Runnable {
    private int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                //唤醒
                notify();
                if (num <= 100) {
                    System.out.println(Thread.currentThread().getName() + ": " + num);
                    num++;
                    try {
                        //阻塞，并释放🔓
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
