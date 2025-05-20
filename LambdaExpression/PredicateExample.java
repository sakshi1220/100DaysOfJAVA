import java.util.function.IntPredicate;
// predicate has and,or,negate
public class Main{
    public static void main(String[] args){
        IntPredicate lessThan10= (value)->{
            
                if(value<10){
                    return true;
                }
                else{
                    return false;
                }
            
        };
        System.out.println(lessThan10.test(11));
    }
}