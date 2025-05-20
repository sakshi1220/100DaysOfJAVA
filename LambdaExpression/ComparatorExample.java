 import java.util.List;
 import java.util.ArrayList;
 import java.util.Collections;
 class Data{
    String name;

    public Data(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return name;
    }

 }

 public class ComparatorExample{
    public static void main(String [] args){
        List<Data> list = new ArrayList<>();
    list.add(new Data("sakshi"));
    list.add(new Data("sharma"));
    list.add(new Data("payal"));
    Collections.sort(list, (Data o1,Data o2)->{
        return o1.getName().compareTo(o2.getName());
    }
    );
    for (Data l: list){
        System.out.println(l);
    }
    }
 }