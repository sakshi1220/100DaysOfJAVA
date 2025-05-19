public class JoinsExample{
     public static int counter1=0;
     public static void main (String [] args){
        Thread thread1= new Thread(()->{
           
            
                for(int i=0; i<1000; i++){
                    counter1++;
                }
            
        });
        thread1.start();
        System.out.println("Counter1 " + counter1);
     }
}