package project;

import java.sql.Time;

public class TimeSlot {
    String shiftName;
    Time startingTime;
    Time endingTime;
    
    public TimeSlot(String name, Time start, Time end){
        this.shiftName=name;
        this.startingTime=start;
        this.endingTime=end;
    }
}
