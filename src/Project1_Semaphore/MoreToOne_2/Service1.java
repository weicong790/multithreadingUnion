package Project1_Semaphore.MoreToOne_2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多进路-单处理-多出路实验
 */
public class Service1 {
    private  Semaphore semaphore = new Semaphore(3);
    private ReentrantLock lcok = new ReentrantLock();
    public void sayHello(){
        try {
            semaphore.acquire();
            System.out.println("ThreadName="+Thread.currentThread().getName()+ "准备");
            lcok.lock();
            System.out.println("end hello || Time="+System.currentTimeMillis());
            for(int i=0;i<4;i++) {
                System.out.println(Thread.currentThread().getName() + "打印:" + i);
            }
            System.out.println("end hello ||  Time="+System.currentTimeMillis());
            lcok.unlock();
            semaphore.release();
            System.out.println("ThreadName="+Thread.currentThread().getName()+ "结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
