package Project1_Semaphore.repastTest;

public class Producer extends Thread{
    private RepastService service ;

    public Producer(RepastService service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.set();
    }
}
