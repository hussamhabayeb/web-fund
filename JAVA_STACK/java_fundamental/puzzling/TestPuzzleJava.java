import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class TestPuzzleJava {
    
	public static void main(String[] args) {

		PuzzleJava generator = new PuzzleJava();




	

        // Character  getRandomLetter= generator.getRandomLetter();
    	// System.out.println(getRandomLetter);   

        // String generatePassword= generator.generatePassword();
    	// System.out.println(generatePassword);   

        String [] getNewPasswordSet= generator.getNewPasswordSet(3);
        for (String pass : getNewPasswordSet){
            System.out.println(pass);
        }
    	System.out.println(Arrays.toString(getNewPasswordSet));   
		

	}   
}
