package Project3_Phaser.arrive3_10;

import java.util.concurrent.Phaser;

/**
 * arrive()方法：使getArrivedParties计数+1，并且不在屏障处等待，直接向下继续运行，并且如果经过屏障点则会重置计数。
 * 当计数不足的时候，其他线程依旧呈等待状态
 */
public class MyService {
    public Phaser phaser;

    public MyService(Phaser phaser){
        super();
        this.phaser = phaser;
    }

    public void testMethodA(){
        try{
            System.out.println(Thread.currentThread().getName() + "begin A1 "+System.currentTimeMillis());
            Thread.sleep(3000);
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + "end A1 "+System.currentTimeMillis());

            System.out.println(Thread.currentThread().getName() + "begin A2 "+System.currentTimeMillis());
            Thread.sleep(3000);
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + "end A2 "+System.currentTimeMillis());

            System.out.println(Thread.currentThread().getName() + "begin A3 "+System.currentTimeMillis());
            Thread.sleep(3000);
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + "end A3 "+System.currentTimeMillis());

        }catch (InterruptedException e){

        }
    }

    public void testMethodB(){
            System.out.println(Thread.currentThread().getName() + " begin B1 "+System.currentTimeMillis());
            System.out.println("arrived parties = " + phaser.getArrivedParties());
            phaser.arrive();//parties达到屏障数=3后自动重置为0
            System.out.println("arrived parties = " + phaser.getArrivedParties());
            System.out.println(Thread.currentThread().getName() + "end B1 "+System.currentTimeMillis());

            System.out.println(Thread.currentThread().getName() + "begin B2 "+System.currentTimeMillis());
            System.out.println("arrived parties = " + phaser.getArrivedParties());
            phaser.arrive();//parties达到屏障数=3后自动重置为0
            System.out.println("arrived parties = " + phaser.getArrivedParties());
            System.out.println(Thread.currentThread().getName() + "end B2 "+System.currentTimeMillis());

            System.out.println(Thread.currentThread().getName() + "begin B3 "+System.currentTimeMillis());
            System.out.println("arrived parties = " + phaser.getArrivedParties());
            phaser.arrive();//parties达到屏障数=3后自动重置为0
            System.out.println("arrived parties = " + phaser.getArrivedParties());
            System.out.println(Thread.currentThread().getName() + "end B3 "+System.currentTimeMillis());
    }
}
