 abstract class Pay{
    String method;
    public void pay(){
        System.out.println("I used" + this.method + "method");
    }
}

class CreditCard extends Pay{
    public CreditCard(){
    this.method="UPI";
    }
    
}

public class AbstractClass{
    public static void main(String [] args){
        CreditCard pay1= new CreditCard();
        pay1.pay();
    }
}