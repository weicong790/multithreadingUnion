package Project3_Phaser.getPhaser3_5;

import java.util.concurrent.Phaser;

/**
 * getPhase()获取已经到达的第几个屏障
 */
public class ThreadA extends Thread {
    private Phaser phaser;

    public ThreadA(Phaser phaser){
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println("A end phase value ="+phaser.getPhase());
        System.out.println("A begin");
        phaser.arriveAndAwaitAdvance();
        System.out.println("A end phase value ="+phaser.getPhase());

        System.out.println("A begin");
        phaser.arriveAndAwaitAdvance();
        System.out.println("A end phase value ="+phaser.getPhase());

        System.out.println("A begin");
        phaser.arriveAndAwaitAdvance();
        System.out.println("A end phase value ="+phaser.getPhase());
    }
}
