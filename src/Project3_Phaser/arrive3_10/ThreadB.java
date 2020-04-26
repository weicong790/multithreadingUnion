package Project3_Phaser.arrive3_10;

public class ThreadB extends Thread {
    MyService myService;

    public ThreadB(MyService myService){
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethodB();
    }
}
