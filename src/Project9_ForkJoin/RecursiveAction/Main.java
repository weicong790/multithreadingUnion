package Project9_ForkJoin.RecursiveAction;

import java.util.concurrent.ForkJoinPool;

/**
 * RecursiveAction执行的任务无返回值
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new MyRecursiveAction(1,10));
        Thread.sleep(5000);
    }
}
