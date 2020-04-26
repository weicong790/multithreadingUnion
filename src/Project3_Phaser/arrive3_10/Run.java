package Project3_Phaser.arrive3_10;

import java.util.concurrent.Phaser;

public class Run {
    public static void main(String[] args) {

        Phaser phaser = new Phaser(3);
        MyService service = new MyService(phaser);

        ThreadA a1 = new ThreadA(service);
        a1.setName("A1  ");
        ThreadA a2 = new ThreadA(service);
        a2.setName("A2  ");
        ThreadB b = new ThreadB(service);
        b.setName("B  ");

        a1.start();
        a2.start();
        b.start();
    }
}
