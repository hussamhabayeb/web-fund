public class Bat extends Mammal {
    
    private int energylevel=300;


  

    public int getEnergylevel() {
        return energylevel;
    }

    public void setEnergylevel(int energylevel) {
        this.energylevel = energylevel;
    }

    
    public void fly(){
        setEnergylevel(getEnergylevel()-50);
        System.out.println("the sound of the bat  is squeak and  loosing energylevel by : " + 
        energylevel +"/300");
        if(getEnergylevel()<0){
            System.out.println("the bat was dead ");

        }
    }
    public void eatHumans(){
        setEnergylevel(getEnergylevel()+25);
        System.out.println("the sound of the bat  is squeak and  gaining energylevel by : " +
         energylevel +"/300");
        

    }
    public  void attackTown(){
        setEnergylevel(getEnergylevel()-100);
        System.out.println("the sound of the bat  is squeak and  loosing energylevel by : " + 
        energylevel +"/300");
        if(getEnergylevel()<0){
            System.out.println("the bat was dead ");
        }
    }

}
