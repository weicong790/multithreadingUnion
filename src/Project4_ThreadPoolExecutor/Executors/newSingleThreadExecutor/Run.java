package Project4_ThreadPoolExecutor.Executors.newSingleThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 3、单一线程池，使线程按队列方式来执行任务
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();

        for(int i=0;i<5;i++){
            service.execute(new MyRunnable(""+i));
        }
        Thread.sleep(3000);
        for(int i=0;i<5;i++){
            service.execute(new MyRunnable(""+i));
        }
    }
}
