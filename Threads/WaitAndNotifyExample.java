public class WaitAndNotifyExample{
  
        public static int balance=0;
        synchronized public void withdraw(int amount) throws InterruptedException{
            if(balance<=0){
                System.out.println("Balance updating");
                wait();
            }
            balance=balance-amount;
            System.out.println(balance);
        }
        public void deposit(int amount){
          synchronized (this) { 
            System.out.println("Depositing");
            balance=balance+amount;
            notify();
          }
        }
        
          public static void main(String [] args){
            WaitAndNotifyExample main= new WaitAndNotifyExample();
            Thread thread1= new Thread(new Runnable(){
                @Override
                public void run(){
                    try{ 
                    main.withdraw(1000);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
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
                    main.deposit(2000);
                }
            });
             thread2.setName("Thread 2");
             thread2.start();
    }
}