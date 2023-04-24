public class Item {
    public String name;
    public Double price;



    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void display(){
        System.out.println(this.name);
    }

}

