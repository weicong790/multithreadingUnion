package Project9_ForkJoin.RecusiveTaskSum;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.concurrent.RecursiveTask;

public class SumRecursive extends RecursiveTask<Integer> {
    private int begin;
    private int end;

    public SumRecursive(Integer begin,Integer end){
        super();
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if(end!=begin){
            int middle = (begin+end)/2;
            SumRecursive leftTask = new SumRecursive(begin,middle);
            SumRecursive rightTask = new SumRecursive(middle+1,end);
            this.invokeAll(leftTask,rightTask);
            return leftTask.join()+rightTask.join();
        }else{
            return end;
        }
    }
}
