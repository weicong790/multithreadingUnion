package Project2_CountDownLatchAndCyclicBarrier.CountDownLatch_1;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService service =  new MyService();
        MyThread t = new MyThread(service);
        t.start();
        Thread.sleep(2000);
        service.downMethod();
    }
}
