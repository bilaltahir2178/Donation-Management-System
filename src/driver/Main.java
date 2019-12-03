package driver;

import java.util.ArrayList;
import java.util.List;
import newpackage.DbConnectivity;
import people.Volunteer;

public class Main {
    public static void main(String[] args){
        List<Volunteer> volunteers = new ArrayList<>();
        volunteers.add(new Volunteer(true, 0, "Ahmad", "331", "AAddress", "090078601", "01/01/2000"));
        volunteers.add(new Volunteer(true, 1, "Bilal", "332", "BAddress", "090078602", "01/02/2000"));
        volunteers.add(new Volunteer(true, 2, "Usama", "333", "UAddress", "090078603", "01/03/2000"));
        volunteers.add(new Volunteer(true, 3, "Ehtisham", "334", "EAddress", "090078604", "01/04/2000"));
        DbConnectivity db = new DbConnectivity();
        db.allocateTeam(volunteers, 1, 1);
    }
}
