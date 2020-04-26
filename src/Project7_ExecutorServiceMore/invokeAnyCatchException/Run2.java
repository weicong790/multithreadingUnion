package Project7_ExecutorServiceMore.invokeAnyCatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * invokeAny()与执行快的任务的异常
 * 执行比较快的任务如果出现异常，默认情况下不在控制台输出异常信息，除非显式try-catch捕获
 * 先出现异常的任务不影响后续其他任务的执行，invokeAny()方法会返回第一个执行成功的值
 */
public class Run2 {
    public static void main(String[] args) {
        try{
            List list = new ArrayList();
            list.add(new MyCallableA());//比较慢的线程
            list.add(new MyCallableCatch2());//比较快的线程且catch异常

            ExecutorService executorService = Executors.newCachedThreadPool();
            String getValueA = (String) executorService.invokeAny(list);

            System.out.println("========="+getValueA);
            System.out.println("zzzzzzzzzzzzzzzzzzzzzz");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
