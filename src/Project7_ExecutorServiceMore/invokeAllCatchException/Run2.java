package Project7_ExecutorServiceMore.invokeAllCatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * invokeAll()：快线程抛出异常，慢线程正常
 * 第一次获取结果，由于快线程抛出异常，直接进入了catch ExecutionException，剩下的结果无法打印
 */
public class Run2 {
    public static void main(String[] args) {
        try {
            Callable1 callable1 = new Callable1();//慢线程
            Callable3 callable3 = new Callable3();//快线程且抛异常

            List<Callable<String>> list = new ArrayList<>();
            list.add(callable3);
            list.add(callable1);

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
            e.printStackTrace();
        }
    }
}
