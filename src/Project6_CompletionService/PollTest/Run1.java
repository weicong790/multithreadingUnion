package Project6_CompletionService.PollTest;

import java.util.concurrent.*;

/**
 * poll()非阻塞，如果任务未执行完，则返回null
 * poll(long timeout, TimeUnit unit),等待额定的时间，在规定时间内获取到值or超时则向下继续运行
 */
public class Run1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Executor executor = Executors.newCachedThreadPool();
        CompletionService csRef = new ExecutorCompletionService(executor);

        MyCallable callable1 = new MyCallable("A",5000);
        MyCallable callable2 = new MyCallable("B",10000);

        csRef.submit(callable1);
        csRef.submit(callable2);

        for(int i=0;i < 2;i++){
            //System.out.println("zzzzzzz "+csRef.poll());
            System.out.println("xxxxxxx "+csRef.poll(6, TimeUnit.SECONDS).get());
        }
        System.out.println("main end");
    }
}
