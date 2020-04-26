package Project1_Semaphore.MoreToOne_1;

public class MyThread extends Thread {
    private Service1 service ;

    public MyThread(Service1 service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.sayHello();
    }
}
