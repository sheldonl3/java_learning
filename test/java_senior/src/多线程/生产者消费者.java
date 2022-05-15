package 多线程;

public class 生产者消费者 {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p = new Producer(clerk);
        p.setName("生产者");

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者");

        p.start();
        c1.start();
    }
}

//店员
class Clerk {
    private int num = 0;

    //生产 获取商品
    public synchronized void getProduce() {
        if (num < 20) {
            num++;
            System.out.println(Thread.currentThread().getName() + "生产、获取第" + num + "个产品");
            notify();
        }else {
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumeProduce() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "消费第" + num + "个产品");
            num--;
            notify();
        }else {
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

//生产者
class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始生产...");
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.getProduce();
        }
    }
}

//消费者
class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始消费...");
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduce();
        }
    }
}