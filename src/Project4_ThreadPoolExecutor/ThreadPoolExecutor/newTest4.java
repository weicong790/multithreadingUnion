package Project4_ThreadPoolExecutor.ThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 4、线程数量>maximumPoolSize && 队列使用 SynchronousQueue,
 *    将发生异常。
 */
public class newTest4 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable = new MyRunnable();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(7,8,5, TimeUnit.SECONDS,new SynchronousQueue<>());

        executor.execute(runnable);//1
        executor.execute(runnable);//2
        executor.execute(runnable);//3
        executor.execute(runnable);//4
        executor.execute(runnable);//5
        executor.execute(runnable);//6
        executor.execute(runnable);//7
        executor.execute(runnable);//8
        executor.execute(runnable);//9 运行到此处，超过maximumPoolSize，抛出异常

        Thread.sleep(300);

        System.out.println("corePoolSize: "+executor.getCorePoolSize());//标准线程数，不进行回收
        System.out.println("poolSize: "+executor.getPoolSize());//正在运行的线程数
        System.out.println("Queue Size: "+executor.getQueue().size());//拓展队列中等待的任务数

        Thread.sleep(5001);
        System.out.println("corePoolSize: "+executor.getCorePoolSize());
        System.out.println("poolSize: "+executor.getPoolSize());
        System.out.println("Queue Size: "+executor.getQueue().size());

    }
}
