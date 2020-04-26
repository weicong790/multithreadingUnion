package Project8_ScheduledExecutorService.RunnbleDelay;

public class RunnableB implements Runnable {
    @Override
    public void run() {
        System.out.println("call B begin:"+Thread.currentThread().getName()+" "+System.currentTimeMillis());
        System.out.println("call B end:"+Thread.currentThread().getName()+" "+System.currentTimeMillis());
    }
}
