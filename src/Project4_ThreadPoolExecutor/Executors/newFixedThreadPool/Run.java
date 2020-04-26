package Project4_ThreadPoolExecutor.Executors.newFixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 2、有界线程池。
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);

        for(int i=0;i<5;i++){
            service.execute(new MyRunnable(""+i));
        }
        Thread.sleep(3000);
        for(int i=0;i<5;i++){
            service.execute(new MyRunnable(""+i));
        }
    }
}
