package Project3_Phaser.getPhaser3_5;

import java.util.concurrent.Phaser;

public class Run {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        ThreadA th = new ThreadA(phaser);
        th.start();
    }
}
