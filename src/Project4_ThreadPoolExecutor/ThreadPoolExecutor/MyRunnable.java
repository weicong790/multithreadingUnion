package Project4_ThreadPoolExecutor.ThreadPoolExecutor;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " run! " + System.currentTimeMillis());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
