package Project3_Phaser.arriveAndDeregister3_4;

import java.util.concurrent.Phaser;

/**
 * arriveAndDeregister方法测试
 *   使当前线程退出，并且使 parties-1
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
        System.out.println("degeister before:"+phaser.getRegisteredParties());
        phaser.arriveAndDeregister();
        System.out.println("degeister after:"+phaser.getRegisteredParties());
        System.out.println(Thread.currentThread().getName()+"B1() end at"+System.currentTimeMillis());

    }
}
