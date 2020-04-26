package Project1_Semaphore.repastTest;

public class Consumer extends Thread {
    private RepastService service;

    public Consumer(RepastService service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.get();
    }
}
