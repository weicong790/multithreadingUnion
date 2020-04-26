package Project3_Phaser.onAdvance3_5;

import java.util.concurrent.Phaser;

public class Service {
    private Phaser phaser;

    public Service(Phaser phaser){
        super();
        this.phaser = phaser;
    }

    public void testMethod(){
        try{
            System.out.println("A begin ThreadName="+ Thread.currentThread().getName()+"   "+System.currentTimeMillis());
            if(Thread.currentThread().getName().equals("B")){
                Thread.sleep(5000);
            }
            phaser.arriveAndAwaitAdvance();
            System.out.println("B end ThreadName="+ Thread.currentThread().getName()+"   "+System.currentTimeMillis());


            System.out.println("B begin ThreadName="+ Thread.currentThread().getName()+"   "+System.currentTimeMillis());
            if(Thread.currentThread().getName().equals("B")){
                Thread.sleep(5000);
            }
            phaser.arriveAndAwaitAdvance();
            System.out.println("B end ThreadName="+ Thread.currentThread().getName()+"   "+System.currentTimeMillis());


            System.out.println("C begin ThreadName="+ Thread.currentThread().getName()+"   "+System.currentTimeMillis());
            if(Thread.currentThread().getName().equals("B")){
                Thread.sleep(5000);
            }
            phaser.arriveAndAwaitAdvance();
            System.out.println("C end ThreadName="+ Thread.currentThread().getName()+"   "+System.currentTimeMillis());
        }catch (InterruptedException e){

        }
    }
}
