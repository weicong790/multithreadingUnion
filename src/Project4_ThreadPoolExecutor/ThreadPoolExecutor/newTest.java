package Project4_ThreadPoolExecutor.ThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 1、当运行线程数 < = CorePoolSize 时，马上创建线程运行这个任务，并不放入拓展队列里
 */
public class newTest {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable = new MyRunnable();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(7,8,5, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        executor.execute(runnable);//1
        executor.execute(runnable);//2
        executor.execute(runnable);//3
        executor.execute(runnable);//4
        executor.execute(runnable);//5
        executor.execute(runnable);//6
        executor.execute(runnable);//7

        Thread.sleep(300);

        System.out.println("corePoolSize: "+executor.getCorePoolSize());//标准线程数，不进行回收
        System.out.println("poolSize: "+executor.getPoolSize());//正在运行的线程数
        System.out.println("Queue Size: "+executor.getQueue().size());//拓展队列中等待的任务数

        Thread.sleep(5001);//验证超过5秒后，PoolSize=CorePoolSize说明指定的核心线程不回收
        System.out.println("corePoolSize: "+executor.getCorePoolSize());
        System.out.println("poolSize: "+executor.getPoolSize());
        System.out.println("Queue Size: "+executor.getQueue().size());

        //池中还有线程在等待任务，所以程序不会停止
    }
}
