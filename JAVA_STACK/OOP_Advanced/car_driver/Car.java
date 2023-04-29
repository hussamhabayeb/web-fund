public class Car{
   private int gas=10;




public int getGas() {
    
    return gas;
}



public void setGas(int gas) {
    this.gas = gas;
}



private boolean game_over = false ;  


   
    public void  status(){
        System.out.println("gas remaing :"+gas);
        if(gas==0){
            System.out.println("game over");
            game_over=true;
        }
    }

}