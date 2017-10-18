package qacinema;

import java.util.Scanner;

public class QACinema {
    public static void main(String[] args) {
        // TODO code application logic here
        Day today = new Day();
        Scanner reader = new Scanner(System.in);
        
        Ticket standard = new Ticket("Standard", 8);                    //create tickets
        Ticket student = new Ticket("Student", 6);
        Ticket oap = new Ticket("OAP", 6);
        Ticket child = new Ticket("Child", 4);
        
        Basket basket = new Basket(standard, oap, student, child);      //initiate basket
        
        UI ui = new UI(reader, basket, today, standard, student, oap, child);
        ui.start(); 
    }
}