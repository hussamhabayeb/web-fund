public class TestOrderItem {
    


    public static void main (String [] args){

        // Menu items
        Item item1 = new Item("mocha", 3.5);
        Item item2 = new Item("latte", 2.5 );
        Item item3 = new Item("drip coffee", 1.5);
        Item item4 = new Item("capuccino", 5.5);
    // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("husssam");
        Order order4 = new Order("khaid");
        Order order5 = new Order("mahdi");
    
        order1.additem(item1);
        order1.additem(item2);
    
        order2.additem(item4);
        order2.additem(item3);
    
        order3.additem(item1);
        order3.additem(item4);
    
        order4.additem(item3);
        order4.additem(item1);
    
        order5.additem(item2);
        order5.additem(item4);
    
        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
    
        order1.setOfReady(true);
        order3.setOfReady(true);
        order5.setOfReady(true);
    
        System.out.println(order1.getStatusMessage());
        System.out.println(order2.getStatusMessage());
    
        }
    }
    



