package Project4_ThreadPoolExecutor.ThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * shutDown()方法不会阻塞，调用方法后，线程池状态变为SHUTDOWN，而线程池会继续运行直到所有任务（包括队列中的任务）执行完才会停止。
 * shutDownNow()方法中断所有任务，不再处理队列中的任务，并且抛出InterruptedException异常
 * 执行之后均无法往线程池添加任何任务
 *
 * isShutDown()：判断线程池关闭命令是否发出(shutDown()是否执行)
 * isTerminating():是否正在关闭进行中
 * isTerminated():是否已经关闭
 * awaitTermination(long timeout,TimeUnit unit):等待timeout时间后判断线程池是否终止，这个方法将阻塞timeout时间长
 *                                              如果在阻塞的过程中任务执行完毕，则取消阻塞，继续向下执行
 */
public class shutDownTest {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable3 runnable = new MyRunnable3();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1,10,0L, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        pool.execute(runnable);
        pool.execute(runnable);
        pool.execute(runnable);
        pool.shutdown();
        //pool.shutdownNow();
        //pool.execute(runnable);
        System.out.println("shutDown?="+pool.isShutdown());
       /* System.out.println("Terminating?="+pool.isTerminating()+" Terminated?="+pool.isTerminated());
        Thread.sleep(1000);
        System.out.println("Terminating?="+pool.isTerminating()+" Terminated?="+pool.isTerminated());
        Thread.sleep(1000);
        System.out.println("Terminating?="+pool.isTerminating()+" Terminated?="+pool.isTerminated());
        Thread.sleep(1000);*/
        System.out.println("是否终止？"+pool.awaitTermination(1,TimeUnit.SECONDS));
        System.out.println("main end");
    }
}
