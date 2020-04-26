package Project4_ThreadPoolExecutor.Executors.newCachedThreadPool2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 无界线程池，可以进行自动回收，池中存放线程个数理论上是Integer.MAX_VALUR
 *    Executors.newCachedThreadPool()返回了一个ThreadPoolExecutor类
 *    executor创建一个线程执行任务，调用多次则多个线程是异步的，多个线程的begin时间几乎相同
 *
 */
public class MyRun {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("---1、创建无界线程池---");
        ExecutorService service = Executors.newCachedThreadPool();
       /* System.out.println("---1、创建10个线程。无复用情况---");
        for(int i=0;i<10;i++){
            service.execute(new MyRunnable(""+i));
        }*/

        System.out.println("---2、复用情况。后五个会复用前面已经执行完任务并且回收了的线程---");
        for(int i=0;i<5;i++){
            service.execute(new MyRunnable(""+i));
        }
        Thread.sleep(3000);
        for(int i=0;i<5;i++){
            service.execute(new MyRunnable(""+i));
        }


        System.out.println("---2、创建无界线程池---");
    }
}
