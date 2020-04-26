package Project7_ExecutorServiceMore.invokeAnyTest1;

import java.util.concurrent.Callable;

public class MyCallableC implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("callable C begin  "+System.currentTimeMillis());
        for(int i=0;i < 223;i++){
            if(Thread.currentThread().isInterrupted()==false){
                Math.random();
                Math.random();
                Math.random();
                System.out.println("callable C at:"+(i+1));
            }else{
                System.out.println("-----C抛出异常-----");
                throw new InterruptedException();
            }

        }
        System.out.println("callable C end   "+System.currentTimeMillis());
        return "returnC";
    }
}
