package Project1_Semaphore.PoolList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用Semaphore创建字符串池
 */
public class ListPool {
    private int poolMaxSize = 3;
    private int semaphorePermits = 5;
    private List<String> list = new ArrayList<>();
    private Semaphore semaphore = new Semaphore(semaphorePermits);
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public ListPool(){
        super();
        for (int i=0;i<poolMaxSize;i++){
            list.add("字符串"+i);
        }
    }

    public String get(){
        String getString = null;
        try{
            semaphore.acquire();
            lock.lock();
            while(list.size()==0){
                condition.await();
            }
            getString = list.remove(0);
            lock.unlock();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return getString;
    }

    public void put(String string){
        lock.lock();
        list.add(string);
        condition.signalAll();
        lock.unlock();
        semaphore.release();
    }

}
