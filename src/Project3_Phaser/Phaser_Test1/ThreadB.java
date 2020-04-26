package Project3_Phaser.Phaser_Test1;

import java.util.concurrent.Phaser;

public class ThreadB extends Thread{
    private Phaser phaser;

    public ThreadB(Phaser phaser){
        super();
        this.phaser = phaser;
    }

    @Override
    public void run() {
        try {
            PrintTools.methodB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
