package Project3_Phaser.onAdvance3_5;

import java.util.concurrent.Phaser;

public class ThreadB extends Thread{
    private Service service;

    public ThreadB(Service service ){
        super();
        this.service = service;
    }

    @Override
    public void run(){
        service.testMethod();
    }
}
