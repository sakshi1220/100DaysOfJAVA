public class VolatileExample{
   volatile public static int flag=0;
    public static void main(String [] args){
        // there is possibility that even if flag value has updated still thread1 may 
        // cache this value to avoid this we use cache
        new Thread( new Runnable(){
            @Override
            public void run(){
                int i=0;
                while(true){
                    if(flag==0){
                        System.out.println(i);
                        i++;
                    }
                }
            }
        }).start();
        new Thread( new Runnable(){
            public void run(){
            try{
            Thread.sleep(1000);
            flag=1;
            System.out.println("value updated");
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            }
        }).start();
    }
}