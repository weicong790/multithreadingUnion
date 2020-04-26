package Project4_ThreadPoolExecutor.ThreadPoolExecutor;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * setRejectedExecutionHandler（）：当任务超过maximumPoolSize时默认抛异常，可以设置任务被拒绝后执行的代码行来替代抛异常
 */
public class RejectedHandlerTest {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1,3,5000L, TimeUnit.SECONDS,new SynchronousQueue<>());
        pool.setRejectedExecutionHandler(new MyRejectedExecutionHandler());
        pool.execute(runnable);
        pool.execute(runnable);
        pool.execute(runnable);
        pool.execute(runnable);
    }
}
