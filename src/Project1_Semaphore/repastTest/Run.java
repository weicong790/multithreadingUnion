package Project1_Semaphore.repastTest;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        RepastService service = new RepastService();
        Producer[] producers = new Producer[60];
        Consumer[] consumers = new Consumer[60];

        for(int i=0;i<60;i++){
            producers[i] = new Producer(service);
            consumers[i] = new Consumer(service);
        }
        Thread.sleep(2000);
        for(int i =0;i<60;i++){
            producers[i].start();
            consumers[i].start();
        }
    }
}
