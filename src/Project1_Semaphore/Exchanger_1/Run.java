package Project1_Semaphore.Exchanger_1;

import java.util.concurrent.Exchanger;

public class Run {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ThreadA a = new ThreadA(exchanger);
        ThreadB b = new ThreadB(exchanger);
        a.start();
        b.start();
        System.out.println("mOK¾Íain end");
    }
}
