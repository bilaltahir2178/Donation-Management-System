package project;

import java.sql.Time;

public class TimeSlot {

    String shiftName;
    Time startingTime;
    Time endingTime;

    public TimeSlot(String name, long start, long end) {
        this.shiftName = name;
        this.startingTime = new Time(start);
        this.endingTime = new Time(end);
    }
}
