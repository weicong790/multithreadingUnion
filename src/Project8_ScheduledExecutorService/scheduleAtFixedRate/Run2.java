package Project8_ScheduledExecutorService.scheduleAtFixedRate;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * 执行任务时间 < period预定时间
 */
public class Run2 {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        System.out.println(" x="+System.currentTimeMillis());
        executor.scheduleAtFixedRate(new RunnableB(),1,2, TimeUnit.SECONDS);
        System.out.println(" y="+System.currentTimeMillis());
    }
}
