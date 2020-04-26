package Project7_ExecutorServiceMore.invokeAllTest1;

import java.util.concurrent.Callable;

public class Callable2 implements Callable<String > {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" begin at:"+System.currentTimeMillis());
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName()+" end at:"+System.currentTimeMillis());
        return "return 2";
    }
}
