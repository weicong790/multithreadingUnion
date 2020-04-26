package Project8_ScheduledExecutorService.CallableDelay;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 使用Callable接口进行任务延迟运行，具有返回值功能
 * public <V> ScheduledFuture<V> schedule(Callable<V> callable,long delay, TimeUnit unit)
 * 的delay表示在多个任务中同时消耗的时间并不是单一任务执行完后再等待4秒
 *
 * Executors.newSingleThreadScheduledExecutor()返回的是ScheduledThreadPoolExecutor(1)
 * Executors.newScheduledThreadPool(2)可以创建指定大小的任务池
 *
 */
public class Test {
    public static void main(String[] args) {
        try{
            List<Callable> callableList = new ArrayList<>();
            callableList.add(new MyCallableA());
            callableList.add(new MyCallableB());

            //取得单一任务的计划执行池
            //ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
            ScheduledFuture<String> futureA = executorService.schedule(callableList.get(0),4L, TimeUnit.SECONDS);
            ScheduledFuture<String> futureB = executorService.schedule(callableList.get(1),4L, TimeUnit.SECONDS);

            System.out.println("       x="+System.currentTimeMillis());
            System.out.println("返回值A:"+futureA.get());//阻塞
            System.out.println("返回值B:"+futureB.get());
            System.out.println("       y="+System.currentTimeMillis());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
