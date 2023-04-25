public class Mammal{
    private int energylevel=100;


    public int getEnergylevel() {
        return energylevel;
    }


    public void setEnergylevel(int energylevel) {
        this.energylevel = energylevel;
    }


    public int displayEnergy(){
        System.out.println("Mammal energylevel is : " + energylevel+ "/100");
        return energylevel;

    }


} 