package Project7_ExecutorServiceMore.invokeAnyCatchException;

import java.util.concurrent.Callable;

public class MyCallable3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("callable  begin  " + System.currentTimeMillis());
        for (int i = 0; i < 22; i++) {
            if (Thread.currentThread().isInterrupted() == false) {
                System.out.println("callable  at:" + (i + 1));
            }
        }
        if(1==1){
            throw new Exception("callable excepetion");
        }
        return "return";
    }
}
