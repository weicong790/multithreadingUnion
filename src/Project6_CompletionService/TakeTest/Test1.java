package Project6_CompletionService.TakeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * CompletionService解决了Future阻塞的特性，哪个任务先完成，哪个任务就可以先被获得并且打印返回值。
 * take()方法：取得最先完成任务的Future对象。依旧是阻塞的，若当前没有任务被执行完，则阻塞。
 */
public class Test1 {
    public static void main(String[] args) {
        try{
            MyCallable callable1 = new MyCallable("username1",5000);
            MyCallable callable2 = new MyCallable("username2",4000);
            MyCallable callable3 = new MyCallable("username3",3000);
            MyCallable callable4 = new MyCallable("username4",2000);
            MyCallable callable5 = new MyCallable("username5",1000);

            List<Callable> callables = new ArrayList<>();
            callables.add(callable1);
            callables.add(callable2);
            callables.add(callable3);
            callables.add(callable4);
            callables.add(callable5);

            ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,5, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
            CompletionService csRef = new ExecutorCompletionService(executor);
            for(int i=0;i<5;i++){
                csRef.submit(callables.get(i));
            }

            for(int i=0;i < 5;i++){
                System.out.println("等待打印第"+(i+1)+"个返回值");
                System.out.println(csRef.take().get());//csRef.take()取得Future对象，并且是先完成任务的先获得
            }
        }catch (Exception e){

        }finally {

        }
    }
}
