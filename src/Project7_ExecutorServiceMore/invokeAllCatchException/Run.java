package Project7_ExecutorServiceMore.invokeAllCatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * invokeAll()：快线程的正确执行，慢的抛出异常
 * invokeAll()对Callable抛出的异常是可以处理的，在main中直接进入ExecutionException捕获模块中
 * 但是由于其他线程没有进行interrupted的判断，所以会继续执行，并且比抛出异常的线程快的返回结果可以被打印出来
 */
public class Run {
    public static void main(String[] args) {
        try {
            Callable1 callable1 = new Callable1();//快线程
            Callable2 callable2 = new Callable2();//慢线程且抛异常

            List<Callable<String>> list = new ArrayList<>();
            list.add(callable1);
            list.add(callable2);

            System.out.println("begin at:" + System.currentTimeMillis());
            ExecutorService service = Executors.newCachedThreadPool();
            List<Future<String>> future = service.invokeAll(list);

            for(int i=0;i<future.size();i++){
                System.out.println("返回的结果："+future.get(i).get() +" time="+System.currentTimeMillis());
            }

            System.out.println("end at:"+System.currentTimeMillis());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("ExecutionException报错了！");
            e.printStackTrace();
        }

    }
}
