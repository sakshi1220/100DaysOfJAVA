import java.util.concurrent.CountDownLatch;
class SomeThread extends Thread{
    private CountDownLatch latch;
    public SomeThread(CountDownLatch latch){
        this.latch=latch;
    }
    @Override
    public void run(){
        System.out.println("started");
        System.out.println("ended");
        System.out.println("****");
        latch.countDown();
    }
}
public class CountDownLatchExample{
    public static void main(String [] args) throws InterruptedException{
        CountDownLatch latch= new CountDownLatch(5);
        SomeThread sm1= new SomeThread(latch);
        SomeThread sm2= new SomeThread(latch);
        SomeThread sm3= new SomeThread(latch);
        SomeThread sm4= new SomeThread(latch);
        SomeThread sm5= new SomeThread(latch);
        sm1.start();
        sm2.start();
        sm3.start();
        sm4.start();
        sm5.start();

        latch.await();
        System.out.println("Main Thread");
    }
}