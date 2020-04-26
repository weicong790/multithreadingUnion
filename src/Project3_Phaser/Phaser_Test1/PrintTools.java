package Project3_Phaser.Phaser_Test1;

import java.util.concurrent.Phaser;

/**
 * arriveAndAwaitAdvance方法测试
 * 设置多屏障的功能，当前线程已经到达屏障，在此等待一段时间等到满足条件后继续向下一个屏障点继续执行。
 */
public class PrintTools {
    public static Phaser  phaser;

    public static void methodA(){
        System.out.println(Thread.currentThread().getName()+"A1() begin at"+System.currentTimeMillis());
        phaser.arriveAndAwaitAdvance();//屏障点1
        System.out.println(Thread.currentThread().getName()+"A1() end at"+System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName()+"A2() begin at"+System.currentTimeMillis());
        phaser.arriveAndAwaitAdvance();//屏障点2
        System.out.println(Thread.currentThread().getName()+"A2() end at"+System.currentTimeMillis());
    }

    public static void methodB() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"B1() begin at"+System.currentTimeMillis());
        Thread.sleep(5000);
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName()+"B1() end at"+System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName()+"B2() begin at"+System.currentTimeMillis());
        Thread.sleep(5000);
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName()+"B2() end at"+System.currentTimeMillis());
    }
}
