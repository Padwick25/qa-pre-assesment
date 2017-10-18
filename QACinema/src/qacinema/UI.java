package qacinema;

import java.util.Scanner;

public class UI {
    private Scanner reader;
    private Basket basket;
    private Day today;
    Ticket standard;
    Ticket student;
    Ticket oap;
    Ticket child;
    
    public UI(Scanner reader, Basket basket, Day today, Ticket standard, Ticket student, Ticket oap, Ticket child) {
        this.reader = reader;
        this.basket = basket;
        this.today = today;
        this.standard = standard;
        this.student = student;
        this.oap = oap;
        this.child = child;
    }
    
    public void help() {                                            //help command
        System.out.println("Available commands:");
        System.out.println("help - View the help menu.");
        System.out.println("tickets - View all available tickets.");
        System.out.println("add - Add a number of any sort of ticket to the basket.");
        System.out.println("remove - Remove a number of any sort of ticket to the basket.");
        System.out.println("basket - See how many of each ticket is available, and your current total.");
        System.out.println("checkout - Make your final purchase.");
        System.out.println("quit - Leave, cancelling all items in the basket.");
    }
    
    public void start() {
        System.out.println("Hello, and welcome to QA Cinemas!");
        System.out.println(this.today.getDate());
        System.out.println("");
        System.out.println("");
        System.out.println("(DEV) Type 1 now to force Wednesday. Type 2 to force not Wednesday. Enter any other integer to continue as normal (functions off todays date).");
        int dev = Integer.parseInt(reader.nextLine());
        switch (dev) {                                                                   //dev tool to force wednesdays
            case 1:
                standard.wedOffer(true);
                student.wedOffer(true);
                oap.wedOffer(true);
                child.wedOffer(true);
                System.out.println("Today is Wednesday, that means 2 pounds off all tickets!");
                break;
            case 2:
                standard.wedOffer(false);
                student.wedOffer(false);
                oap.wedOffer(false);
                child.wedOffer(false);
                break;
            default:
                standard.wedOffer(today.isWeds());
                student.wedOffer(today.isWeds());
                oap.wedOffer(today.isWeds());
                child.wedOffer(today.isWeds());
                if(today.isWeds()) {
                    System.out.println("Today is Wednesday, that means 2 pounds off all tickets!");
                }
                break;
        }
        System.out.println("");
        System.out.println("");
        basket.printTickets();
        System.out.println("");
        help();
        System.out.println("");
        while(true) {                                               //basket loop, ends with quit or checkout
            System.out.print("Enter a command: ");
            String command = reader.nextLine();
            command = command.toLowerCase();
            System.out.println("");
            if(command.equals("help")) {
                help();
            } else if(command.equals("tickets")) {
                basket.printTickets();
            } else if(command.equals("add")) {
                System.out.println("What sort of ticket would you like to add (standard, student, oap, or child)?");
                String ticketType = reader.nextLine();
                ticketType = ticketType.toLowerCase();
                System.out.println("");
                if(ticketType.equals("standard")) {
                    System.out.println("How many standard tickets would you like to add?");
                    int quantity = Integer.parseInt(reader.nextLine());
                    basket.addTickets(standard, quantity);
                    System.out.println("");
                    basket.printBasket();                           //print basket after all adding/removing tikets for clarity
                } else if(ticketType.equals("student")) {
                    System.out.println("How many student tickets would you like to add?");
                    int quantity = Integer.parseInt(reader.nextLine());
                    basket.addTickets(student, quantity);
                    System.out.println("");
                    basket.printBasket();
                } else if(ticketType.equals("oap")) {
                    System.out.println("How many OAP tickets would you like to add?");
                    int quantity = Integer.parseInt(reader.nextLine());
                    basket.addTickets(oap, quantity);
                    System.out.println("");
                    basket.printBasket();
                } else if(ticketType.equals("child")) {
                    System.out.println("How many child tickets would you like to add?");
                    int quantity = Integer.parseInt(reader.nextLine());
                    basket.addTickets(child, quantity);
                    System.out.println("");
                    basket.printBasket();
                } else {
                    System.out.println("Sorry, ticket not recognized.");
                }
            } else if(command.equals("remove")) {
                System.out.println("What sort of ticket would you like to remove (standard, student, oap, or child)?");
                String ticketType = reader.nextLine();
                ticketType = ticketType.toLowerCase();
                System.out.println("");
                if(ticketType.equals("standard")) {
                    System.out.println("How many standard tickets would you like to remove?");
                    int quantity = Integer.parseInt(reader.nextLine());
                    basket.removeTickets(standard, quantity);
                    System.out.println("");
                    basket.printBasket();
                } else if(ticketType.equals("student")) {
                    System.out.println("How many student tickets would you like to remove?");
                    int quantity = Integer.parseInt(reader.nextLine());
                    basket.removeTickets(student, quantity);
                    System.out.println("");
                    basket.printBasket();
                } else if(ticketType.equals("oap")) {
                    System.out.println("How many OAP tickets would you like to remove?");
                    int quantity = Integer.parseInt(reader.nextLine());
                    basket.removeTickets(oap, quantity);
                    System.out.println("");
                    basket.printBasket();
                } else if(ticketType.equals("child")) {
                    System.out.println("How many child tickets would you like to remove?");
                    int quantity = Integer.parseInt(reader.nextLine());
                    basket.removeTickets(child, quantity);
                    System.out.println("");
                    basket.printBasket();                                               //in fututure streamline functionalit of adding/removing tickets
                } else {
                    System.out.println("Sorry, ticket not recognized.");
                }
            } else if(command.equals("basket")) {
                basket.printBasket();
            } else if(command.equals("checkout")) {
                System.out.println("Purchase of");
                basket.printContents();
                System.out.println("made for \u00A3" + basket.getTotal() + " total.");
                System.out.println("");
                System.out.println("Thank you for shopping with QA cinemas.");
                break;
            } else if(command.equals("quit")) {
                System.out.println("Thank you for shopping with QA cinemas. No purchase has been made.");
                break;
            } else {
                System.out.println("Sorry, command not recognized.");
            }
        System.out.println("");
        }
    }
}