package 多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//多线程创建方式4:线程池
public class ThreadTest3 {
    public static void main(String[] args) {
        //提供指定数量的池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //设置池参数 管理
        ThreadPoolExecutor service = (ThreadPoolExecutor) executorService;
        service.setCorePoolSize(10);

        //提供实现callable runnable的对象，制定线程操作
        executorService.execute(new NumThread2());//适合runnable
        executorService.execute(new NumThread3());
        //executorService.submit();              //适合callbale
        //关闭线程池
        executorService.shutdown();
    }
}

class NumThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NumThread3 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}