package Project3_Phaser.onAdvance3_5;


public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service ){
        super();
        this.service = service;
    }

    @Override
    public void run(){
        service.testMethod();
    }
}
