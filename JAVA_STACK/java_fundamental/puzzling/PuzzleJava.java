
import java.util.ArrayList;
import java.util.Random;

    






public class PuzzleJava{
    
    
Random randMachine = new Random();

    public ArrayList<Integer>  getTenRolls(){
        ArrayList<Integer> anyarr = new ArrayList<Integer>();
        for(int i=0;i<= 10;i++){
            int randnum=randMachine.nextInt(20);
            anyarr.add(randnum);
     
        
     }
    return anyarr ;
    
    }

    public Character getRandomLetter(){
        ArrayList<Character> thingArr = new   ArrayList<Character>();
        
        int randNum=randMachine.nextInt(26);
        for (int i=0 ; i <=25;i++){
            char c = (char)(randMachine.nextInt(26) + 'a');
            thingArr.add(c);
        
        }
        
        return  thingArr.get(randNum);
     }
     public String generatePassword(){
        String pass="";
        
        
        for (int i=0 ; i <=7;i++){
           pass =pass+getRandomLetter();
        
        }
      
        return  pass;
    }  
    
    public String [] getNewPasswordSet(int length){
        String [] passArr = new String [length];

        for ( int i=0 ; i< length ; i++){
            String pass="";
            for (int j=0 ; j <=7;j++){
               pass =pass+getRandomLetter();
            }
            passArr[i]=pass;
        }
       
      
        return  passArr;
    }
    
}