package Project7_ExecutorServiceMore.invokeAllCatchException;

import java.util.concurrent.Callable;

//慢线程且抛异常
public class Callable2 implements Callable<String > {
    @Override
    public String call() throws NullPointerException {
            System.out.println("callable  begin  " + System.currentTimeMillis());
            for (int i = 0; i < 222; i++) {
                if (Thread.currentThread().isInterrupted() == false) {
                    Math.random();
                    System.out.println("callable  at:" + (i + 1));
                }
            }
            if(1==1){
                throw new NullPointerException("出现异常");
            }
            return "return catch";
    }
}
