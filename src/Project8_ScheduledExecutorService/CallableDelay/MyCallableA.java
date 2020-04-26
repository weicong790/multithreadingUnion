package Project8_ScheduledExecutorService.CallableDelay;

import java.util.concurrent.Callable;

public class MyCallableA implements Callable<String> {
    @Override
    public String call() throws Exception {
        try{
            System.out.println("call A begin:"+Thread.currentThread().getName()+" "+System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("call A end:"+Thread.currentThread().getName()+" "+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "return A";
    }
}
