package Project3_Phaser.awaitAdvance3_11;

import java.util.concurrent.Phaser;

public class ThreadB extends Thread {
    private Phaser phaser;

    public ThreadB(Phaser phaser){
        this.phaser = phaser;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+ "B1 begin=" + System.currentTimeMillis());
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName()+ "B1 end=" + System.currentTimeMillis());
    }
}
