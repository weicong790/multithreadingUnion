package Project3_Phaser.onAdvance3_5;

import java.util.concurrent.Phaser;

/**
 * onAdvance将在通过新的屏障时被调用，并且返回true时取消屏障，false保持屏障
 */
public class Run {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2){
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("protected boolean onAdvance 被调用了");
                return true;//取消屏障
            }
        };

        Service service = new Service(phaser);

        ThreadA a = new ThreadA(service);
        ThreadB b = new ThreadB(service);
        a.setName("A");
        b.setName("B");
        a.start();
        b.start();
    }
}
