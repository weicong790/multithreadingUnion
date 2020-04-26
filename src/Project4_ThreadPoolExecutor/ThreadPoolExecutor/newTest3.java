package Project4_ThreadPoolExecutor.ThreadPoolExecutor;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 3、当数量 > CorePoolSize && <= maximumPoolSize && 队列使用 SynchronousQueue ，
 *    maximumPoolSize、keepAliveTime参数有效，线程数>CorePoolSize时将创建非核心线程运行多余任务，即放入池中运行，而非队列里等待
 *   当keepAliveTime>5时将清除空闲线程，且只回收非核心线程
 */
public class newTest3 {
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

        Thread.sleep(300);

        System.out.println("corePoolSize: "+executor.getCorePoolSize());//标准线程数，不进行回收
        System.out.println("poolSize: "+executor.getPoolSize());//poolSize: 8
        System.out.println("Queue Size: "+executor.getQueue().size());//

        Thread.sleep(8000);
        System.out.println("corePoolSize: "+executor.getCorePoolSize());
        System.out.println("poolSize: "+executor.getPoolSize());//poolSize: 7 ，只回收非核心线程
        System.out.println("Queue Size: "+executor.getQueue().size());
    }
}
