package Project2_CountDownLatchAndCyclicBarrier.CountDownLatch_4;

import java.util.concurrent.CountDownLatch;

public class Run {
    public static void main(String[] args) {
        try{
            CountDownLatch commingTag = new CountDownLatch(10);//等待所有运动员到来
            CountDownLatch waitTag = new CountDownLatch(1);//等待裁判说准备
            CountDownLatch waitRunTag = new CountDownLatch(10);//等待起跑
            CountDownLatch beginTag = new CountDownLatch(1);//起跑
            CountDownLatch endTag = new CountDownLatch(10);//等待所有运动员到达终点

            MyThread[] tArray = new MyThread[10];
            for(int i = 0;i < 10;i++){
                tArray[i] = new MyThread(commingTag,waitRunTag,waitTag,beginTag,endTag);
                tArray[i].setName("运动员"+i);
                tArray[i].start();
            }

            System.out.println("裁判等待所有运动员到达起跑点");
            commingTag.await();

            System.out.println("裁判看到所有运动员到来，各就各位前巡视5秒");
            Thread.sleep(5000);
            waitTag.countDown();

            System.out.println("各就各位");
            waitRunTag.await();

            System.out.println("发令枪：砰！");
            beginTag.countDown();
            endTag.await();
            System.out.println("比赛结束");

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
