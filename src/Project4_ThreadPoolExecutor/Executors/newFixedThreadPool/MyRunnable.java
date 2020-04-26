package Project4_ThreadPoolExecutor.Executors.newFixedThreadPool;

public class MyRunnable implements Runnable{
    String uername;

    public MyRunnable(String name){
        super();
        this.uername = name;
    }

    @Override
    public void run() {
        try{
            System.out.println(Thread.currentThread().getName()+"username="+uername+" Runnable begin " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()+"username="+uername+" Runnable end " + System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
