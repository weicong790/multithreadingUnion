package Project3_Phaser.arriveAndDeregister3_4;

import java.util.concurrent.Phaser;

/**
 * Phaser类具有设置多屏障的功能，当前线程已经到达屏障，在此等待一段时间等到满足条件后继续向下一个屏障点继续执行。
 * 参数parties表示屏障条件为：当parties个线程调用arriveAndAwaitAdvance。当线程不满足该个数时，将阻塞。
 */
public class Run {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);
        PrintTools.phaser = phaser;

        ThreadA a = new ThreadA(phaser);
        ThreadB b = new ThreadB(phaser);
        a.setName("A ");
        b.setName("B ");
        a.start();
        b.start();
    }
}
