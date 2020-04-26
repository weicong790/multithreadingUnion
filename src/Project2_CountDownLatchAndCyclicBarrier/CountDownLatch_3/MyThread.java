package Project2_CountDownLatchAndCyclicBarrier.CountDownLatch_3;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread{
    private CountDownLatch maxRunner;//控制运动员数量

    public MyThread(CountDownLatch maxRunner){
        this.maxRunner = maxRunner;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"到了");
        maxRunner.countDown();
    }
}
