package Project7_ExecutorServiceMore.invokeAnyCatchException;

import java.util.concurrent.Callable;

public class MyCallableA implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("callable A begin  "+System.currentTimeMillis());
        for(int i=0;i < 123;i++){
            Math.random();
            Math.random();
            Math.random();
            System.out.println("callable A at:"+(i+1));
        }
        System.out.println("callable A end   "+System.currentTimeMillis());
        return "returnA";
    }
}
