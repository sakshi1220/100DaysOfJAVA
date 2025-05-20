import java.util.Arrays;
import java.util.List;
public class ForEachLambda{
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(2,3,4,5,6,7);
       list.forEach((x)->System.out.println(x));
    }
}