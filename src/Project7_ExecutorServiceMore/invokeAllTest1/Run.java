package Project7_ExecutorServiceMore.invokeAllTest1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * invokeAll()会返回所有任务的执行结果，并且此方法执行的效果也是阻塞执行的。要把所有结果都取回时才继续向下执行。
 */
public class Run {
    public static void main(String[] args) {
        try {
            Callable A = new Callable1();
            Callable B = new Callable2();

            List<Callable<String>> list = new ArrayList<>();
            list.add(A);
            list.add(B);

            System.out.println("begin at:"+System.currentTimeMillis());
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
