package Project2_CountDownLatchAndCyclicBarrier.CountDownLatch_2;

/**
 * 模拟当所有运动员准备好了之后开始比赛
 * 此代码有问题：
 * 当线程调用CoudownLatch.await()方法之前如果运行时间过长，而主线程调用countDown()方法在线程之前，是不对的。
 * 这样相当于裁判在运动员准备好之前就发出开始比赛信号。
 * 完整比赛的代码详见4
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        ReadyService service = new ReadyService();
        MyThread[] tArray = new MyThread[num];
        for(int i = 0;i < num;i++){
            tArray[i] = new MyThread(service);
            tArray[i].setName("运动员"+i);
            tArray[i].start();
        }
        service.down();
    }
}
