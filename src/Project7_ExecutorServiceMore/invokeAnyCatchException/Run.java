package Project7_ExecutorServiceMore.invokeAnyCatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 方法invokeAny()与执行慢的任务的异常
 * 想捕捉Callable中的异常，必须显式添加try-catch，但在mian方法里捕捉不到，
 *  因为：子线程出现异常时不影响主线程
 */
public class Run {
    public static void main(String[] args) {
        try{
            List  list = new ArrayList();
            list.add(new MyCallableA());//比较快的线程
            list.add(new MyCallableCatch());//比较慢的线程且catch异常

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
