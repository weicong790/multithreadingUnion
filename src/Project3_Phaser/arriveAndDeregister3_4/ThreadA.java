package Project3_Phaser.arriveAndDeregister3_4;

import java.util.concurrent.Phaser;

public class ThreadA extends Thread {
    private Phaser phaser;

    public ThreadA(Phaser phaser){
        super();
        this.phaser = phaser;
    }

    @Override
    public void run() {
        PrintTools.methodA();
    }
}
