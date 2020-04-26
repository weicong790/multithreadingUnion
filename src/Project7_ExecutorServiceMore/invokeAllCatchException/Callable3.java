package Project7_ExecutorServiceMore.invokeAllCatchException;

import java.util.concurrent.Callable;
//快线程且抛异常
public class Callable3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("callable C begin  "+System.currentTimeMillis());
        for(int i=0;i < 50;i++){
            Math.random();
            System.out.println("callable C at:"+(i+1));
        }
        if(1==1){
            throw new NullPointerException("出现异常");
        }
        System.out.println("callable C end   "+System.currentTimeMillis());
        return "return C";
    }
}
