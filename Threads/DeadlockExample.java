
public class DeadlockExample {
    public static void main(String [] args) throws InterruptedException {
        String lock1="lock1";
        String lock2= "lock2";
        Thread thread1 = new Thread(()->{
            synchronized(lock1){
                System.out.println("thread1, lock1");
                synchronized(lock2){
                 System.out.println("thread1,lock2");    
                }
            }
        });
         Thread thread2 = new Thread(()->{
             synchronized(lock2){
                System.out.println("thread2,lock2");
                synchronized(lock1){
                 System.out.println("thread2,lock1");    
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