public class Driver extends Car {
    
    
    public void drive(){
        setGas(getGas()-1) ;
    }

    public void boosters(){
        setGas(getGas()-3);
      System.out.println("i am using boosters"+getGas());
    }

    public void refuel(){
        setGas(getGas()+2);
        System.out.println("i am using refuel"+getGas());
    }
}
