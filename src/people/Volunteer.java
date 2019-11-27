package people;

import java.sql.Time;
import project.TimeSlot;

public class Volunteer extends Person {

    int totalWorkingHours;
    TimeSlot availability;
    TimeSlot workingTime;

    //Give time in 24 hours format
    private long calculateTime(String hours, String minutes) {
        long mHours = Long.parseLong(hours);
        long mMinutes = Long.parseLong(minutes);
        long mMilliSeconds = (mHours * 60 * 60000) + (mMinutes * 60000);
        return mMilliSeconds;
    }

    public Volunteer(String name, int age, String cnic, String address, int workingHours) {
        super(name, age, cnic, address);
        this.totalWorkingHours = workingHours;
    }

    void setAvailibility(String name, String sHour, String sMinute, String eHour, String eMinute, Time end) {
        this.availability = new TimeSlot(name, calculateTime(sHour, sMinute), calculateTime(eHour, eMinute));
    }

    void workingTime(String name, String sHour, String sMinute, String eHour, String eMinute, Time end) {
        this.workingTime = new TimeSlot(name, calculateTime(sHour, sMinute), calculateTime(eHour, eMinute));
    }
}
