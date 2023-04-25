public class BankAccount{

    private double checking_balance ;
    private double savings_balance ;
    static int numOfAccount=0 ;
    static double TotalMoney =0 ;
    

    public BankAccount(double checking_balance , double savings_balance){
        this.checking_balance=checking_balance;
        this.savings_balance=savings_balance;
        numOfAccount++ ;
    }

    public double getChecking_balance() {
        return checking_balance;
    }
   
    
    public double getSavings_balance() {
        return savings_balance;
    }
   

    public void depositToSaving(double AmountOfMoney){
        this.savings_balance+=AmountOfMoney;
        TotalMoney +=AmountOfMoney;
        System.out.println("your balance saving account : "+this.savings_balance);
    }
    public void depositToChecking(double AmountOfMoney){
        this.checking_balance+=AmountOfMoney;
        TotalMoney +=AmountOfMoney;
        System.out.println("your balance cheacking account : "+this.checking_balance);
    }
    public void withdraw (double AmountOfMoney){

        if (savings_balance>AmountOfMoney){
        this.savings_balance-=AmountOfMoney;
        TotalMoney-=AmountOfMoney ;
        System.out.println("your balance cheacking account : "+this.savings_balance);
        }
        else {
        System.out.println("oparetion failed");
    
        }
    }
    public double totalamountofmonye (){
        return TotalMoney;
    }


}