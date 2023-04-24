import java.util.HashMap;
import java.util.Set;
public class HashMapTest{
            public static void main(String[] args) {

        HashMap<String,String> tracklist=new HashMap<String,String>();
        tracklist.put("Eminem", "Killers");
        tracklist.put("Brown mars", "24K Magic");
        tracklist.put("Adele", "set fire to the rain");
        tracklist.put("Sia", " Unstoppable");


        Set<String> keys = tracklist.keySet();
        for(String key : keys) {
            System.out.println(key);
            System.out.println(tracklist.get(key));  
                }       
}
}