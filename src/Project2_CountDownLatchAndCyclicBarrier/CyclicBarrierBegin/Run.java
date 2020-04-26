package Project2_CountDownLatchAndCyclicBarrier.CyclicBarrierBegin;

import java.util.concurrent.CyclicBarrier;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        //设置最大为5个的parties同行者，当5个线程执行了await方法后才会执行一次runnable里的run方法，并且线程才会继续往下运行。
        //否则这些线程彼此等待，一直呈阻塞状态。
        //当parties数量小于运行的线程时，将会分批循环。（当有parties个线程执行了await之后，会进行重置屏障点）
        CyclicBarrier cbRef = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println(" 全部到了！");
            }
        });


        MyThread[] threadsArray =  new MyThread[5];
        for(int i=0;i<5;i++){
            threadsArray[i] = new MyThread(cbRef);
            threadsArray[i].start();
            Thread.sleep(1000);
            System.out.println("到达屏障点线程个数："+cbRef.getNumberWaiting());
        }
    }
}
