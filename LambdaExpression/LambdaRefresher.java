interface Data{
    public float demo(int x,float y);
}
public class LambdaRefresher{
    public static void main(String[] arg){
        int x=9; float y=9.0f;
        Data d=(l,b)->{
            
            return x+y;
        };
        System.out.println(d.demo(x,y));
    }
}