package Project9_ForkJoin.RecusiveTask;

import java.util.concurrent.ForkJoinPool;
/**
 * 使用Recursive实现字符串累加
 */
public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        MyRecursiveTask task = new MyRecursiveTask(1,10);
        pool.submit(task);
        System.out.println("----main----"+task.join());
    }
}
