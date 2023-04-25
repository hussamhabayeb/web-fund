import java.util.ArrayList;

public class TestBankAccount {

    public static void main(String[] argo){
       BankAccount account1=new BankAccount(200, 500);

       account1.depositToChecking(200);
       account1.depositToSaving(200);
       account1.withdraw(400);
    
    }
}
