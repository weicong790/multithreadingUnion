package Project4_ThreadPoolExecutor.ThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 2、当数量 > CorePoolSize &&  队列使用 LinkedBlockingDeque ，
 *     maximumPoolSize、keepAliveTime参数无效，大于CorePoolSize时将任务放入队列中，
 *    同一时刻最多只能有CorePoolSize个线程在运行
 *    LinkedBlockingDeque是容量很大的队列，没有大小限制
 */
public class newTest2 {
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
        executor.execute(runnable);//8

        Thread.sleep(300);

        System.out.println("corePoolSize: "+executor.getCorePoolSize());//标准线程数，不进行回收
        System.out.println("maximunPoolSize: "+executor.getMaximumPoolSize());//允许的最大线程数
        System.out.println("poolSize: "+executor.getPoolSize());//正在运行的线程数
        System.out.println("Queue Size: "+executor.getQueue().size());//拓展队列中等待的任务数

        Thread.sleep(5001);
        System.out.println("corePoolSize: "+executor.getCorePoolSize());
        System.out.println("poolSize: "+executor.getPoolSize());
        System.out.println("Queue Size: "+executor.getQueue().size());

        //池中还有线程在等待任务，所以程序不会停止
    }
}
