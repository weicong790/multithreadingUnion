package Project8_ScheduledExecutorService.scheduleWithFixedDelay;

public class RunnableA implements Runnable {
    @Override
    public void run() {
        try{
            System.out.println("call A begin:"+Thread.currentThread().getName()+" "+System.currentTimeMillis());
            //Thread.sleep(4000);
            System.out.println("call A end:"+Thread.currentThread().getName()+" "+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
