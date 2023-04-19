import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil{

   public int getStreakGoal(){
    int sum = 0 ;
    for (int i =0 ;i<=10;i++){
        sum +=i ;

    }
    return sum ;
   }

   public double getOrderTotal(double[] prices){
    double sum =0;
    for(double p :  prices){
       sum += p;
    }
    return sum ;
   }
   public void displayMenu(ArrayList <String> menuItems){
    for (int i = 0; i <= menuItems.size()-1 ; i++) {
        System.out.println(menuItems.get(i));
      }
   }
   public void addCustomer(ArrayList<String> customers){
    System.out.println("please enter your name :");
    String userName = System.console().readLine();
    System.out.println("Hello"+userName); 
    System.out.println("there are" +customers.size()+ " people head of you");
    customers.add(userName);

}
}
   
