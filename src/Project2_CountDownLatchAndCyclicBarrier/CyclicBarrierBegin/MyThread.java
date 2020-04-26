package Project2_CountDownLatchAndCyclicBarrier.CyclicBarrierBegin;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread  extends Thread{
    private CyclicBarrier cbRef;

    public MyThread(CyclicBarrier cbRef){
        super();
        this.cbRef = cbRef;
    }

    @Override
    public void run() {
        try{
            Thread.sleep((int)(Math.random()*1000));
            System.out.println(Thread.currentThread().getName() + " 到了，Time="+System.currentTimeMillis());
            cbRef.await();
            System.out.println(Thread.currentThread().getName() + " 等待全部到了之后，Time="+System.currentTimeMillis());
        }catch (InterruptedException e){

        }catch (BrokenBarrierException e){

        }
    }
}
