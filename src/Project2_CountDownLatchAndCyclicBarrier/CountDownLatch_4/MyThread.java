package Project2_CountDownLatchAndCyclicBarrier.CountDownLatch_4;

import java.util.concurrent.CountDownLatch;

public class MyThread extends  Thread {
    private CountDownLatch commingTag;//等待所有运动员到来
    private CountDownLatch waitTag;//等待裁判说准备
    private CountDownLatch waitRunTag;//等待起跑
    private CountDownLatch beginTag;//起跑
    private CountDownLatch endTag;//等待所有运动员到达终点


    public MyThread(CountDownLatch commingTag, CountDownLatch waitRunTag, CountDownLatch waitTag,
                    CountDownLatch beginTag, CountDownLatch endTag) {
        super();
        this.commingTag = commingTag;
        this.waitRunTag = waitRunTag;
        this.waitTag = waitTag;
        this.beginTag = beginTag;
        this.endTag = endTag;
    }

    @Override
    public void run() {
        try{
            System.out.println("运动员们正往起跑线点走来...");
            Thread.sleep((int)Math.random()*10000);//运动员每个人向起跑点走来的速度不同
            System.out.println(Thread.currentThread().getName()+"到达起跑点");
            commingTag.countDown();

            System.out.println("————等待裁判说准备————");
            waitTag.await();

            System.out.println("————裁判说：准备起跑！————");
            Thread.sleep((int)Math.random()*10000);
            waitRunTag.countDown();

            System.out.println(Thread.currentThread().getName()+"起跑了");
            beginTag.await();
            Thread.sleep((int)Math.random()*10000);
            System.out.println(Thread.currentThread().getName()+"到达终点");
            endTag.countDown();

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
