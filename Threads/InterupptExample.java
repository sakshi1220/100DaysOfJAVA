public class InterupptExample{
  //if we are withdrawing more than we have in our bank, we will intrupt the thread where we are withdrawing
  // if there is no wait or catch block to handle interrupt exception, interrupt block will have no impact.
        public static int balance=0;
        synchronized public void withdraw(int amount) {
             try{
            while(balance<amount){
                System.out.println("Balance updating");
               
                wait();
            }
              
                
                balance=balance-amount;
                System.out.println(balance);
             }
                catch(InterruptedException e){
                    System.out.println(balance);
                    return;
                }
            
            
            
        }
        public boolean deposit(int amount){
          synchronized (this) { 
            if(amount>0){
            System.out.println("Depositing");
            balance=balance+amount;
            notify();
            return true;
            }
            else{
                System.out.println("Amount is less");
                return false;
            }
          }
        }
        
          public static void main(String [] args){
            InterupptExample main= new InterupptExample();
            Thread thread1= new Thread(new Runnable(){
                @Override
                public void run(){                 
                    main.withdraw(1000);
                    
                }
            });
            thread1.setName("Thread 1");
            thread1.start();

            Thread thread2= new Thread(new Runnable(){
                @Override
                public void run(){
                    try{
                        Thread.sleep(2000);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    boolean success=main.deposit(0);
                    if(success){
                        System.out.println("Transaction Completed");
                    }
                    else{
                        thread1.interrupt();
                    }
                }
            });
             thread2.setName("Thread 2");
             thread2.start();
    }
}