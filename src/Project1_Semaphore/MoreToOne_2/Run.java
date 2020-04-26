package Project1_Semaphore.MoreToOne_2;

public class Run {
    public static void main(String[] args){
        Service1 service1 = new Service1();
        MyThread[] threadsArray = new MyThread[12];
        for(int i=0;i<threadsArray.length;i++){
            threadsArray[i] = new MyThread(service1);
            threadsArray[i].start();
        }
    }
}
