package Project9_ForkJoin.RecusiveTask;

/**
 * 使用RecursiveTask实现字符串累加
 *
 */

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<String> {
    private int beginValue;
    private int endValue;

    public MyRecursiveTask(int beginValue,int endValue){
        super();
        this.beginValue = beginValue;
        this.endValue = endValue;
    }

    @Override
    protected String compute() {
        System.out.println(Thread.currentThread().getName()+"----"+beginValue+"---"+endValue);

        if(endValue - beginValue > 2){
            int middleValue = (endValue + beginValue)/2;
            MyRecursiveTask leftTask = new MyRecursiveTask(beginValue,middleValue);
            MyRecursiveTask rightTask = new MyRecursiveTask(middleValue+1,endValue);
            this.invokeAll(leftTask,rightTask);

            return leftTask.join()+rightTask.join();//使用join获得返回值
        }else {
            String r = "";
            for(int i=beginValue;i<=endValue;i++){
                r  =  r + (i);
            }
            System.out.println("else 返回："+r + " "+beginValue+" "+endValue);
            return r;
        }
    }
}
