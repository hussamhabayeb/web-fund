public class BankAccount{

    private double checking_Balance ;
    private double savings_Balance ;
    static int numOfAccount=0 ;
    static double TotalMoney =0 ;
    

    public BankAccount(double checking_balance , double savings_Balance){
        this.checking_Balance=checking_balance;
        this.savings_Balance=savings_Balance;
        this.TotalMoney=checking_balance+savings_Balance ;
        numOfAccount++ ;
    }

    public double getChecking_balance() {
        return  this.checking_Balance;
    }
   
    
    public double getSavings_balance() {
        return this.savings_Balance;
    }
   

    public void depositToSaving(double AmountOfMoney ){
        this.savings_Balance+=AmountOfMoney;
        TotalMoney +=AmountOfMoney;
        System.out.println("your balance saving account : "+this.savings_Balance);
    }
    public void depositToChecking(double AmountOfMoney){
        this.checking_Balance+=AmountOfMoney;
        TotalMoney +=AmountOfMoney;
        System.out.println("your balance cheacking account : "+this.checking_Balance);
    }
    public void withdraw (double AmountOfMoney){

        if (savings_Balance>AmountOfMoney){
        this.savings_Balance-=AmountOfMoney;
        TotalMoney-=AmountOfMoney ;
        System.out.println("your balance saving_balance account : "+this.savings_Balance);
        }
        else {
        System.out.println("oparetion failed");
    
        }
    }
    public double totalamountofmonye (){
        return TotalMoney;
    }


}