import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.TimeUnit;

public class DeadlockPreventionExample {
    static Lock lock1= new ReentrantLock();
    static Lock lock2= new ReentrantLock();
    public static void main(String [] args) throws InterruptedException {
        
        Thread thread1 = new Thread(()->{
          boolean flagLock01=false;
          boolean flagLock02=false;
          while(true){
            try{
            flagLock01=lock1.tryLock(10,TimeUnit.MILLISECONDS);
            flagLock02=lock2.tryLock(10,TimeUnit.MILLISECONDS);
          }catch(InterruptedException e){
            e.printStackTrace();
          }finally{
            if(flagLock01){
                System.out.println("Thread1, lock1");
                lock1.unlock();
            }
            if(flagLock02){
                System.out.println("Thread1, lock2");
                lock2.unlock();
            }
            if(flagLock01 && flagLock02){
                break;
            }
          }
          }
        });
         Thread thread2 = new Thread(()->{
            boolean flagLock01=false;
          boolean flagLock02=false;
          while(true){
            try{
            flagLock01=lock1.tryLock(10,TimeUnit.MILLISECONDS);
            flagLock02=lock2.tryLock(10,TimeUnit.MILLISECONDS);
          }catch(InterruptedException e){
            e.printStackTrace();
          }finally{
            if(flagLock01){
                System.out.println("Thread2, lock1");
                lock1.unlock();
            }
            if(flagLock02){
                System.out.println("Thread2, lock2");
                lock2.unlock();
            }
            if(flagLock01 && flagLock02){
                break;
            }
          }
          }  
            

        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Main Thread");
    }
}