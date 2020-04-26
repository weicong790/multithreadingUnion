package Project3_Phaser.awaitAdvance3_11;

import java.util.concurrent.Phaser;

public class ThreadC extends Thread{
    private Phaser phaser;

    public ThreadC(Phaser phaser){
        this.phaser = phaser;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+ "C1 begin=" + System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.awaitAdvance(2);
        System.out.println(Thread.currentThread().getName()+ "C1 end=" + System.currentTimeMillis());
    }
}
