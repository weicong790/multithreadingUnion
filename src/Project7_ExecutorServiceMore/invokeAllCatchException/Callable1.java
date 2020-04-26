package Project7_ExecutorServiceMore.invokeAllCatchException;

import java.util.concurrent.Callable;
//快线程
public class Callable1 implements Callable<String> {
    @Override
    public String call() {
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
