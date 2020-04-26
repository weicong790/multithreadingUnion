package Project1_Semaphore.Exchanger_1;

import java.util.concurrent.Exchanger;

public class ThreadB extends Thread{
    private Exchanger<String> exchanger;

    public ThreadB(Exchanger<String> exchanger){
        super();
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("线程B中得到线程A传输的值为："+exchanger.exchange("中国人B"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread B end!");
    }
}
