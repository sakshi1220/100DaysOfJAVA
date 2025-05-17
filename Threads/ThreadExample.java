import  java.lang.Thread;
class MyCounter extends Thread{
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
            Thread.sleep(5000);
            System.out.println("Thread no " +threadNo+ "and iteration is:" +i);
        }
    }
}

public class ThreadExample{

    public static void main(String [] args){
        MyCounter counter1= new MyCounter(1);
        MyCounter counter2= new MyCounter(2);
         counter1.start();
         System.out.println("************");
         counter2.start();
    }
}