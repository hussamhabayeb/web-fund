public class Gorilla extends Mammal {
    




    public void  throwing(){
        setEnergylevel(getEnergylevel()-5);
        System.out.println("gorilla loosing energy by : " + getEnergylevel()+ "/100");

    }
    public void eatBananas(){
        setEnergylevel(getEnergylevel()+10);
        System.out.println("gorilla gain energy by : " + getEnergylevel()+ "/100");
    }
    public void climb (){
        setEnergylevel(getEnergylevel()-10);
        System.out.println("gorilla  loosing energy by : " + getEnergylevel()+ "/100");
    }
}
