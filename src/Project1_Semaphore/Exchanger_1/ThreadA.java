package Project1_Semaphore.Exchanger_1;

import java.util.concurrent.Exchanger;

public class ThreadA extends Thread {
    private Exchanger<String> exchanger;

    public ThreadA(Exchanger<String> exchanger){
        super();
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("线程A中得到线程B传输的值为："+exchanger.exchange("中国人A"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread A end!");
    }
}
