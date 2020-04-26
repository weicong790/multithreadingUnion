package Project3_Phaser.arrive3_10;

public class ThreadA extends Thread {
    MyService myService;

    public ThreadA(MyService myService){
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethodA();
    }
}
