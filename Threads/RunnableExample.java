import  java.lang.Thread;
import java.util.Random;
class MyCounter implements Runnable{
    private int threadNo;
    public MyCounter(int threadNo){
        this.threadNo= threadNo;
    }
    @Override
    public void run(){
        try{
        countMe();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public void countMe() throws InterruptedException{
        for(int i=0;i<10;i++){
            Random random= new Random();
            Thread.sleep(random.nextInt(5000));
            System.out.println("Thread no " +threadNo+ "and iteration is:" +i);
        }
    }
}
//***Anonmyous Thread (where we need to create only one thread) in main  */
// wasting no resource, eg loading a resource where this micro thread will run behind can optimize the performance too.
//  we can directly call this thread too without creating the instance
public class RunnableExample{

    public static void main(String [] args){
       Thread thread1 = new Thread(new MyCounter(1));
       Thread thread2 = new Thread(new MyCounter(2));
    //    thread1.start();
    //    thread2.start();
       Thread threadAnonmyous= new Thread(new Runnable(){
       @Override
       public void run(){
        try{
        for(int i=0;i<10;i++){
            Random random= new Random();
            Thread.sleep(random.nextInt(5000));
            System.out.println(i);
        }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    
       }

         });
         threadAnonmyous.start();
       
    }
}