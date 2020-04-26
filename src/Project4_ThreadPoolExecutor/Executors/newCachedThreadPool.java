package Project4_ThreadPoolExecutor.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**C
 * 无界线程池，可以进行自动回收，池中存放线程个数理论上是Integer.MAX_VALUR
 * Executors.newCachedThreadPool()返回了一个ThreadPoolExecutor类
 * executor创建一个线程执行任务，调用多次则多个线程是异步的，多个线程的begin时间几乎相同
 */
public class newCachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("A Runnable begin " + System.currentTimeMillis());
                    Thread.sleep(1000);
                    System.out.println("A Runnable end " + System.currentTimeMillis());
                }catch (InterruptedException e){

                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("B Runnable begin " + System.currentTimeMillis());
                    Thread.sleep(1000);
                    System.out.println("B Runnable end " + System.currentTimeMillis());
                }catch (InterruptedException e){

                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println(" Runnable begin " + System.currentTimeMillis());
                    Thread.sleep(1000);
                    System.out.println("C Runnable end " + System.currentTimeMillis());
                }catch (InterruptedException e){

                }
            }
        });

        for(int i=0;i<5;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        System.out.println(" Runnable begin " + System.currentTimeMillis());
                        Thread.sleep(1000);
                        System.out.println(" Runnable end " + System.currentTimeMillis());
                    }catch (InterruptedException e){

                    }
                }
            });
        }
    }
}
