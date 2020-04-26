package Project8_ScheduledExecutorService.CallableDelay;

import java.util.concurrent.Callable;

public class MyCallableB implements Callable {
    @Override
    public Object call() throws Exception {

        System.out.println("call B begin:"+Thread.currentThread().getName()+" "+System.currentTimeMillis());
        System.out.println("call B end:"+Thread.currentThread().getName()+" "+System.currentTimeMillis());
        return "return B";
    }
}
