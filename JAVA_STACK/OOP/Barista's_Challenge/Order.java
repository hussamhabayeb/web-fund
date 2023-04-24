import java.util.ArrayList;

public class Order{

    private String name ;
    private Boolean ready=true  ;
    private ArrayList<Item> items  ;

    public Order(){
        this.name="Guest";
        this.items =new ArrayList <Item>();
    }
    public Order(String name){
        this.name=name;
        this.items =new ArrayList <Item>();

    }



    //getters and setters for name
    public String getOfName(){
       return name;
    }
    public void setOfName(String name){
        this.name=name;
        
    }
    //getters and setters for ready
    public Boolean getOfReady(){
       return ready;
    }
    public void setOfReady(Boolean ready){
        this.ready=ready;
        
    }

        
    public void addItem(Item item){
        this.items.add(item);
    }
    public String getStatusMessage(){
        if (ready==true){   //  = (this.ready==true)
           return "the order is ready";
        }
        else{
            return "have a nice day";
        }
    }
     
    
    public void display(){
        System.out.println("Customer Name: " + this.name);
        double total = 0;
        for(int i = 0; i < items.size(); i++){
            System.out.println(items.get(i).getName() + " - " + items.get(i).getPrice());
            total += items.get(i).getPrice();
        }
        System.out.println("Total:" + total);
    }

    public Double getOrderTotal(){
        double total = 0;
        for(int i = 0; i < items.size(); i++){
            total += this.items.get(i).getPrice();
        }
        return total;
}
}