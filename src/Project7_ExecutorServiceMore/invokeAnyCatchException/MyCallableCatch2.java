package Project7_ExecutorServiceMore.invokeAnyCatchException;

import java.util.concurrent.Callable;

public class MyCallableCatch2 implements Callable {
    @Override
    public Object call() throws Exception {
        try {
            System.out.println("callable  begin  " + System.currentTimeMillis());
            for (int i = 0; i < 22; i++) {
                if (Thread.currentThread().isInterrupted() == false) {
                    Math.random();
                    Math.random();
                    System.out.println("callable  at:" + (i + 1));
                }
            }
            throw new NullPointerException();

        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return "return catch";
    }
}
