package Project7_ExecutorServiceMore.invokeAnyCatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * invokeAny()与所有任务都发生异常
 * 全部任务都抛出异常时，invokeAny()会抛出ExecutionException异常
 */
public class Run3 {
    public static void main(String[] args) {
        try{
            List list = new ArrayList();
            list.add(new MyCallable3());
            list.add(new MyCallable3());

            ExecutorService executorService = Executors.newCachedThreadPool();
            String getValueA = (String) executorService.invokeAny(list);

            System.out.println("========="+getValueA);
            System.out.println("zzzzzzzzzzzzzzzzzzzzzz");
        } catch (InterruptedException e) {
            System.out.println("进入interrupted 异常");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("进入Execution 异常");
            e.printStackTrace();
        }
    }
}
