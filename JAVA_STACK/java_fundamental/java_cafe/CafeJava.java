public class CafeJava {
    public static void main(String[] args){
        String generalGreeting ="welcome in cafe Java," ;
        String pendingMessage =", your order should be ready shortly," ;
        String readyMessage =", your order is ready" ;
        String displayTotalMessage ="Your total is$" ;

        double mochaPrice=3.5;
        double dripCoffePrice=8.5;
        double lattePrice=10;
        double cappuccinoPrice=6;



        String customer1="Cindhuri";
        String customer2="sami";
        String customer3="Jimmy";
        String customer4="Noah";

        
        boolean isReadyOrder1=true;
        boolean isReadyOrder2=true;
        boolean isReadyOrder3=false;
        boolean isReadyOrder4=true;

        if(isReadyOrder1){
            System.out.println(pendingMessage +customer1);
            System.out.println(displayTotalMessage +lattePrice);

        }
        else if(isReadyOrder1){
            System.out.println(pendingMessage+customer1);
        }
       

        System.out.println(displayTotalMessage + mochaPrice);
        
        if(isReadyOrder4){
            System.out.println(generalGreeting + customer4 + readyMessage+
             displayTotalMessage +mochaPrice );
        }

        if(isReadyOrder4){
            System.out.println(generalGreeting+customer3+
            displayTotalMessage+ (mochaPrice * 2 + lattePrice +cappuccinoPrice ));
        }
    }
}


