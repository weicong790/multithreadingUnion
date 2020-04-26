package Project1_Semaphore.MoreToOne_1;

import java.util.concurrent.Semaphore;

/**
 * 多进路-多处理-多出路实验
 */
public class Service1 {
    private  Semaphore semaphore = new Semaphore(3);

    public void sayHello(){
        try {
            semaphore.acquire();
            System.out.println("ThreadName="+Thread.currentThread().getName()+ "准备");
            System.out.println("end hello || Time="+System.currentTimeMillis());
            for(int i=0;i<4;i++) {
                System.out.println(Thread.currentThread().getName() + "打印:" + i);
            }
            System.out.println("end hello ||  Time="+System.currentTimeMillis());
            semaphore.release();
            System.out.println("ThreadName="+Thread.currentThread().getName()+ "结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
