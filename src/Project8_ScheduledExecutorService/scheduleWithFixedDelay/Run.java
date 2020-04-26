package Project8_ScheduledExecutorService.scheduleWithFixedDelay;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * scheduleWithFixedDelay()设置多个任务之间固定的运行时间间隔
 * 执行任务时间 > period预定时间
 * 执行任务时间 < period预定时间
 */
public class Run {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        System.out.println(" x="+System.currentTimeMillis());
        executor.scheduleWithFixedDelay(new RunnableA(),1,2, TimeUnit.SECONDS);
        System.out.println(" y="+System.currentTimeMillis());
    }
}
