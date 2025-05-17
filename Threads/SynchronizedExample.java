 import java.lang.Thread;
 class Brackets{
    private final Object lock="Lock";
    public void generate() throws InterruptedException{

    // we can create a synchronized block as well, it will synchronized a particluar section and gives addnal power and control and make it fast
    // in comparison writing synchronized brfore method, example-:
    synchronized(lock){
        for(int i=1; i<=10; i++){
            Thread.sleep(2000);
            if(i<=5){
                System.out.print('[');
            }
            else{
                  System.out.print(']');
            }
        }
        System.out.println();
    }

        for(int i=1; i<=5; i++){
        Thread.sleep(5000);
    }
    }
    
 }

 public class SynchronizedExample{
    public static void main(String[] args){
        Brackets bracket = new Brackets();
       new Thread(new Runnable(){
        @Override
        public void run(){
            for(int i=0;i<5;i++){
                try{
                bracket.generate();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

       }).start();
       new Thread(new Runnable(){
        @Override
        public void run(){
            for(int i=0;i<5;i++){
                try{
                bracket.generate();
                }
                 catch(InterruptedException e){
                    e.printStackTrace();
                 }
            }
        }

       }).start();
    }
 }
