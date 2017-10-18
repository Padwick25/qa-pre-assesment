package qacinema;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Day {
    private Date date;
    private SimpleDateFormat form;
    
    public Day() {                      //Get day of the week in correct format for wednesday checks
        this.date = new Date();
        this.form = new SimpleDateFormat("EEEE dd/MM/yyyy");
    }
    
    public boolean isWeds() {           //Wednesday check
        if(form.format(this.date).contains("Wed")) {
            return true;
        } else {
            return false;
        }
    }
    
    public String getDate() {
        return form.format(this.date);
    }
}