import java.util.ArrayList;

public class ListOfExceptions{
                public static void main (String [] args){

                 ArrayList<Object> mylist=new ArrayList<Object>();
    
                    mylist.add("13");
                    mylist.add("hellow world");
                    mylist.add("48");
                    mylist.add("Goodbye world");

                    for(int i = 0; i < mylist.size(); i++) {
                        try{
                            Integer castedValue = (Integer) mylist.get(i);
                            System.out.println("The type was casted successfully!");
                        }
                        catch (Exception e){
                            System.out.println("wrong opartion");
                             
                    }
                }
}
}