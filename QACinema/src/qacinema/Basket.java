package qacinema;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<Ticket, Integer> contents;
    private int total;
    
    public Basket(Ticket ticket1, Ticket ticket2, Ticket ticket3, Ticket ticket4) {     //since limited to 4 tickets, only need to account for those
        this.contents = new HashMap<Ticket, Integer>();
        this.contents.put(ticket1, 0);
        this.contents.put(ticket2, 0);
        this.contents.put(ticket3, 0);
        this.contents.put(ticket4, 0);
        this.total = 0;
    }
    
    public void addTickets(Ticket ticket, int quantity) {                               //add tickets to basket
        if(quantity > 0) {
            contents.replace(ticket, contents.get(ticket), contents.get(ticket) + quantity);
            this.total += quantity * ticket.getCost();
        } else if(quantity == 0) {
            System.out.println("Can't add 0 tickets");
        } else {
            System.out.println("Can't add a negative number of tickets (please use remove)");
        }
    }
    
    public void removeTickets(Ticket ticket, int quantity) {                            //remove tickets from basket
        if(contents.get(ticket) - quantity >= 0) {
            contents.replace(ticket, contents.get(ticket), contents.get(ticket) - quantity);
            this.total -= quantity * ticket.getCost(); 
        } else {
            System.out.println("You can't remove more tickets than you have.");
        }
    }
    
    public void printTickets() {                                                        //lots of seperate get/print basket methods, almost certainly don't need all
        System.out.println("Available tickets:");
        for(Ticket ticket : this.contents.keySet()) {
            System.out.println(ticket);
        }
    }
    
    public void printBasket() {
        System.out.println("Your basket contains:");
        for(Ticket ticket : this.contents.keySet()) {
            if(this.contents.get(ticket) > 0) {
                System.out.println(this.contents.get(ticket) + " " + ticket.getName() + " tickets.");
            }
        }
        System.out.println("Current total: \u00A3" + total);
    }
    
    public void printContents() {
         for(Ticket ticket : this.contents.keySet()) {
             System.out.println(this.contents.get(ticket) + " " + ticket.getName() + " tickets");
         }
    }
    
    public int getTotal() {
        return this.total;
    }
}
