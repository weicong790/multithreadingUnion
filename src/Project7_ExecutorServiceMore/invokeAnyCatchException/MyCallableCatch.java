package Project7_ExecutorServiceMore.invokeAnyCatchException;

import java.util.concurrent.Callable;

/**
 * 想捕捉Callable中的异常，必须显式添加try-catch，但在mian方法里捕捉不到，
 * 因为：子线程出现异常时不影响主线程
 *
 *
 */
public class MyCallableCatch implements Callable {

    @Override
    public Object call() {
        try {
            System.out.println("callable  begin  " + System.currentTimeMillis());
            for (int i = 0; i < 222; i++) {
                if (Thread.currentThread().isInterrupted() == false) {
                    Math.random();
                    Math.random();
                    Math.random();
                    Math.random();
                    System.out.println("callable  at:" + (i + 1));
                } else {
                    System.out.println("-----抛出异常-----");
                    throw new InterruptedException();
                }
            }
            System.out.println("callable  end   " + System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "return catch";
    }
}
