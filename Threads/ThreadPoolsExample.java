import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

class SomeThread extends Thread{
    private String name;
    public SomeThread(String name){
        super(name);
        this.name=name;
    }

    @Override
    public void run(){
        System.out.println("Thread started: " + name);

        try{
            Thread.sleep(3000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread Ended: " + name);
    }

    public static void main(String[] args){
        ExecutorService es=  Executors.newFixedThreadPool(2);
        SomeThread thread1= new SomeThread("Hello Thread1");
        SomeThread thread2= new SomeThread("Hello Thread2");
        SomeThread thread3= new SomeThread("Hello Thread3");
        SomeThread thread4= new SomeThread("Hello Thread4");
        SomeThread thread5= new SomeThread("Hello Thread5");
        es.execute(thread1);
        es.execute(thread2);
        es.execute(thread3);
        es.execute(thread4);
        es.execute(thread5);
        es.shutdown();
    }

}