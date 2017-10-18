package qacinema;

public class Ticket {
    private String name;
    private int cost;
    
    public Ticket(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
    
    public void wedOffer(boolean isWeds) {      //take 2 off ticket cost on wednesdays
        if(isWeds) {
            this.cost -= 2;
        }
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getCost() {
        return this.cost;
    }
    
    public String toString() {
        return this.name + " - \u00A3" + this.cost;
    }
}
