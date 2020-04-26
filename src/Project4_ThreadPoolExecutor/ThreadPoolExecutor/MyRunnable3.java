package Project4_ThreadPoolExecutor.ThreadPoolExecutor;

public class MyRunnable3 implements Runnable {
    @Override
    public void run() {
         System.out.println(Thread.currentThread().getName()+"enter Runnble");

         try {
             Thread.sleep(2000);
             if (Thread.currentThread().isInterrupted() == true) {
                 System.out.println("Thread中断了");
                 throw new InterruptedException();
             }
             System.out.println("Thread任务完成");
         }catch (InterruptedException e){
             System.out.println("进入catch");
             //e.printStackTrace();
        }
    }
}
