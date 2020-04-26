package Project9_ForkJoin.RecursiveAction;

import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {
    private int beginValue;
    private int endValue;

    public MyRecursiveAction(int beginValue,int endValue){
        super();
        this.beginValue = beginValue;
        this.endValue = endValue;
    }

    @Override
    protected void compute() {
        System.out.println(Thread.currentThread().getName()+"----"+System.currentTimeMillis());

        if(endValue-beginValue > 2){
            int middleNum = (endValue+beginValue)/2;
            MyRecursiveAction rightAction = new MyRecursiveAction(middleNum+1,endValue);
            MyRecursiveAction leftAction = new MyRecursiveAction(beginValue,middleNum);
            this.invokeAll(leftAction,rightAction);
        }else {
            System.out.println("打印组合为："+beginValue+" , "+endValue);
        }
    }
}
