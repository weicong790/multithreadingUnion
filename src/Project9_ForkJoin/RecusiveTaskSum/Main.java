package Project9_ForkJoin.RecusiveTaskSum;


import java.util.concurrent.ForkJoinPool;

/**
 * 使用RecursiveTask实现求和
 */
public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        SumRecursive task = new SumRecursive(1,100);
        pool.submit(task);
        System.out.println("----main----"+task.join());
    }
}
