package Project2_CountDownLatchAndCyclicBarrier.CountDownLatch_1;

import java.util.concurrent.CountDownLatch;

public class MyService {
    private CountDownLatch down = new CountDownLatch(1);//创建1个计数

    public void testMethod(){
        try {
            System.out.println("A");
            down.await();//阻塞，直到计数被减为0
            System.out.println("B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void downMethod(){
        System.out.println("计数-1之前，此时count="+down.getCount());
        down.countDown();//计数减1
        System.out.println("计数-1之后，此时count="+down.getCount());
    }

}
