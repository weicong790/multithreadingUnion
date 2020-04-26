package Project7_ExecutorServiceMore.invokeAnyTest1;

import java.util.concurrent.Callable;

public class MyCallableB implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("callable B begin  "+System.currentTimeMillis());
        for(int i=0;i < 223;i++){
            Math.random();
            Math.random();
            Math.random();
            System.out.println("callable B at:"+(i+1));
        }
        System.out.println("callable B end   "+System.currentTimeMillis());
        return "returnB";
    }
}
