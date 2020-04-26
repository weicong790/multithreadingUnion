package Project5_FutureAndCallable;

import java.util.concurrent.*;

/**
 * Future的cancel()方法用于取消发送任务，返回是否成功发送命令（并不代表取消成功）。
 * 如果任务已经执行完毕，则cancel失败，返回false
 * 如果在任务完成前cancel成功，则无法再进行get请求，会一直阻塞
 * 进行中的中断必须结合if(Thread.currentThread().isInterrupted())来抛出中断异常,如果没有则不会被中断，但是发送中断的命令是成功的。
 *
 */
class MyCallable2 implements Callable<String>{

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "我永远18岁！";
    }
}

class MyCallable3 implements Callable<String>{

    @Override
    public String call() throws Exception {
        int i = 0;
        while(i==0){
            if(Thread.currentThread().isInterrupted()){
                throw new InterruptedException();
            }
            System.out.println("正在运行中");
        }
       return "我永远18岁";
    }
}
public class CancelTest {
    public static void main(String[] args) {
        try {
            MyCallable2 callable = new MyCallable2();
            ExecutorService executor = new ThreadPoolExecutor(3, 4, 5L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
           /* Future future = executor.submit(callable);
            //System.out.println("before future.get():" + future.cancel(true) + " result:" + future.isCancelled());
            System.out.println(future.get());
            System.out.println("after future.get():" + future.cancel(true) + " result:" + future.isCancelled());*/


            MyCallable3 callable3 = new MyCallable3();
            Future future1 = executor.submit(callable3);
            Thread.sleep(4000);
            System.out.println("before future.get():" + future1.cancel(true) + " result:" + future1.isCancelled());

        }catch (Exception e){

        }

    }
}
