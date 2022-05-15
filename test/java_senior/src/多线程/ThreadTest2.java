package 多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest2 {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        //多了一个FutureTask
        FutureTask futureTask = new FutureTask(numThread);

        new Thread(futureTask).start();

        try {
            //get返回值就是callable对象重写的call返回值
            Object sum = futureTask.get();
            System.out.println("总和是 "+sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}

//多线程创建方式3:实现callable接口
class NumThread implements Callable {
    //实现call方法，可以有返回值
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}