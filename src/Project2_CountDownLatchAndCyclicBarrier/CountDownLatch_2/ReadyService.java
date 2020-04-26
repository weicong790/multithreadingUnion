package Project2_CountDownLatchAndCyclicBarrier.CountDownLatch_2;

import java.util.concurrent.CountDownLatch;

public class ReadyService {
    private CountDownLatch down = new CountDownLatch(1);

    public void testMethod(){
        try {
            System.out.println(Thread.currentThread().getName() + "准备");
            Thread.sleep(5000);
            down.await();
            System.out.println(Thread.currentThread().getName() + "结束");
        }catch (InterruptedException e){

        }
    }

    public void down(){
        System.out.println("开始");
        down.countDown();
    }
}
