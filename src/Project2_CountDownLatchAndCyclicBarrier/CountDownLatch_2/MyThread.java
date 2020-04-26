package Project2_CountDownLatchAndCyclicBarrier.CountDownLatch_2;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread{

    private  ReadyService service ;

    public MyThread(ReadyService service){
        this.service = service;
    }

    @Override
    public void run() {
       service.testMethod();
    }
}
