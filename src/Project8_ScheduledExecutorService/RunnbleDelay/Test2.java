package Project8_ScheduledExecutorService.RunnbleDelay;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) {
        List<Runnable> runnableList = new ArrayList<>();
        runnableList.add(new RunnableA());
        runnableList.add(new RunnableB());
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        System.out.println("       x="+System.currentTimeMillis());
        executorService.schedule(runnableList.get(0),4L, TimeUnit.SECONDS);
        executorService.schedule(runnableList.get(1),4L,TimeUnit.SECONDS);
        System.out.println("       y="+System.currentTimeMillis());
    }
}
