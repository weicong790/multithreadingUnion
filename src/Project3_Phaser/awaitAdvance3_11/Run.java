package Project3_Phaser.awaitAdvance3_11;

import java.util.concurrent.Phaser;

/**
 * awaitAdvance(phase):
 *     如果传入参数phase和getphase相等，则线程在屏蔽处等待，否则向下运行。
 */
public class Run {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);
        ThreadA a = new ThreadA(phaser);
        a.start();
        ThreadB b = new ThreadB(phaser);
        b.start();
        ThreadC c = new ThreadC(phaser);
        c.start();
    }
}
