public class TestOrders {
    /**
     * @param args
     */
    public static void main (String [] args){

        Item item1=new Item();
        Item item2=new Item();
        Item item3=new Item();
        Item item4=new Item();


      

        item1.name="mocha";
        item1.price=3.5 ;

        item2.name="latte";
        item2.price=6.5 ;

        item3.name="drip cafe";
        item3.price=7.5 ;

        item4.name="capuccino";
        item4.price=5.5 ;


        System.out.println(item1.name);
        System.out.println(item2.name);
        System.out.println(item3.name);
        System.out.println(item4.name);


        System.out.println(item1.price);
        System.out.println(item2.price);
        System.out.println(item3.price);
        System.out.println(item4.price);


        Order order1 =new Order();
        Order order2 =new Order();
        Order order3 =new Order();
        Order order4 =new Order();

        order1.name="Cindhuri";
        order2.name="Jimmy";
        order3.name="Noah";
        order4.name="Sam";

        System.out.println(order1.ready);


        order2.items.add(item1);
        order2.items.add(item1.name);



        
            order3.items.add(item4);
        order3.total += item4.price;
        System.out.println(order3.total);

        order4.items.add(item2);
        order4.total += item2.price;
        System.out.println(order3.total);

        order1.ready = true;
        System.out.println(order1.ready);

        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += (item2.price * 2);
        System.out.println(order4.items);
        System.out.println(order4.total);

        order2.ready = true;

        
        }
}   
