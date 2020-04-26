package Project2_CountDownLatchAndCyclicBarrier.CountDownLatch_3;

import java.util.concurrent.CountDownLatch;

/**
 * 通过CountDownLatch模拟:裁判员要等待所有运动员全部到来的效果
 * 论证：
 *      多个线程与同步点间阻塞的特性
 */
public class Run {
    static int num = 10;
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch maxRunner = new CountDownLatch(num);//10个计数
        MyThread[] tArray = new MyThread[num];
        for(int i = 0;i < num;i++){
            tArray[i] = new MyThread(maxRunner);
            tArray[i].setName("运动员"+i);
            tArray[i].start();
        }
        maxRunner.await();
        System.out.println("人员到齐");
    }
}
