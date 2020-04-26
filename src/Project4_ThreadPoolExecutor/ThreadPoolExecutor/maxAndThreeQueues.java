package Project4_ThreadPoolExecutor.ThreadPoolExecutor;

import java.util.LinkedHashMap;
import java.util.concurrent.*;

/**
 * 测试比较三种不同的Queue情况下，当任务数 > maximumPoolSize时的情况
 * 1、LinkedBlockingDeque：使用有参构造，max被参考，最多只能存储指定大小的元素；无参构造，max被忽略，可以存储Integer.MAX_VALUE大小
 * 2、
 */
public class maxAndThreeQueues {
    public static void main(String[] args) {
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque(2);//使用有参构造，最多只能存储指定大小的元素
        System.out.println(linkedBlockingDeque.size());//size = 0
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,3,5, TimeUnit.SECONDS,linkedBlockingDeque);

        //1、总数量 <= maximumPoolSize + pool初始化容量
       /* for(int i=0;i<5;i++){
            pool.execute(new MyRunnable2());
        }
        System.out.println(linkedBlockingDeque.size());//size = 2*/
        /**
         * 结果分析：5个任务，其中有2个由核心线程完成，1个由非核心线程完成，剩下2个任务暂存在linkedBlockingDeque中
         */

        //2、总数量 > maximumPoolSize + pool初始化容量
        /*for(int i=0;i<6;i++){
            pool.execute(new MyRunnable2());
        }
        System.out.println(linkedBlockingDeque.size());//size = 2*/
        /**
         * 结果分析：执行三个任务，放入两个任务到队列中
         * 总共只正常运行5（maximumPoolSize + pool初始化容量）个任务，剩余任务抛出RejectedExecutionException
         */


        //3、ArrayBlockingQueue带参构造，同linkedBlockingDeque，max被参考
       /* ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(2);
        ThreadPoolExecutor pool2 = new ThreadPoolExecutor(2,3,5, TimeUnit.SECONDS,arrayBlockingQueue);
        for(int i=0;i<6;i++){
            pool2.execute(new MyRunnable2());
        }*/
        /**
         * 结果分析，放入队列2个任务，执行3个任务，有一个任务被拒绝
         */

        //4、
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        ThreadPoolExecutor pool3 = new ThreadPoolExecutor(2,3,5, TimeUnit.SECONDS,synchronousQueue);
        for(int i=0;i<6;i++){
            pool3.execute(new MyRunnable2());
        }
        /**
         * 结果分析;3个任务直接执行，其他任务直接被拒绝
         */



    }
}
