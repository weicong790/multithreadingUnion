package Project1_Semaphore.PoolList;

public class MyThread extends Thread{
    ListPool pool = new ListPool();

    public MyThread(ListPool pool){
        super();
        this.pool = pool;
    }

    @Override
    public void run() {
        for(int i=0;i<Integer.MAX_VALUE;i++){
            String getrString = pool.get();
            System.out.println(Thread.currentThread().getName()+"取得字符串："+getrString);
            //pool.put(getrString+"i="+i);
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
