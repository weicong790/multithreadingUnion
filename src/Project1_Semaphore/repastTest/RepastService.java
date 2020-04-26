package Project1_Semaphore.repastTest;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟餐馆生产者——消费者模式
 */
public class RepastService {
    volatile private Semaphore setSemaphore = new Semaphore(10);//十个厨师（生产者）
    volatile private Semaphore getSemaphore = new Semaphore(20);//顾客（消费者）
    volatile private ReentrantLock lock = new ReentrantLock();
    volatile private Condition setCondition = lock.newCondition();
    volatile private Condition getCondition = lock.newCondition();
    volatile private Object[] productPositon = new Object[4];//最多只有四个盘子可以放菜品

    private boolean isEmpty(){
        boolean isEmpty = true;
        for(int i=0;i<productPositon.length;i++){
            if(productPositon[i]!=null){
                isEmpty = false;
            }
        }
        return isEmpty;
    }

    private boolean isFull(){
        boolean isFull = true;
        for(int i=0;i<productPositon.length;i++){
            if(productPositon[i] == null){
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void set(){
        try{
            setSemaphore.acquire();
            lock.lock();
            while(isFull()){
                setCondition.await();
            }
            for(int i=0;i<productPositon.length;i++){
                if(productPositon[i]==null){
                    productPositon[i] = "数据";
                    System.out.println(Thread.currentThread().getName()+"生产了："+productPositon[i]+",位置为："+i);
                    break;
                }
            }
            getCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            setSemaphore.release();
        }
    }

    public void get(){
        try {
            getSemaphore.acquire();
            lock.lock();
            while(isEmpty()){
                getCondition.await();
            }
            for(int i=0;i<productPositon.length;i++){
                if(productPositon[i] != null){
                    System.out.println(Thread.currentThread().getName()+"消费了："+productPositon[i]+",位置为："+i);
                    Thread.sleep(1000);
                    productPositon[i] = null;
                    break;
                }
            }
            getCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            getSemaphore.release();
        }

    }
}
