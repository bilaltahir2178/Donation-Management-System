package people;

import project.TimeSlot;

public class Volunteer extends Person {

    TimeSlot availability;
    TimeSlot workingTime;
    Boolean mAvailability;

    //Give time in 24 hours format
    private long calculateTime(String hours, String minutes) {
        long mHours = Long.parseLong(hours);
        long mMinutes = Long.parseLong(minutes);
        long mMilliSeconds = (mHours * 60 * 60000) + (mMinutes * 60000);
        return mMilliSeconds;
    }

    public Volunteer(boolean availibility,int id, String name, String cnic, String address, String phone, String dateOfBirth) {
        super(id, name, cnic, address, phone, dateOfBirth);
        this.mAvailability = availibility;
    }

    public void setAvailibility(String name, String sHour, String sMinute, String eHour, String eMinute) {
        this.availability = new TimeSlot(name, calculateTime(sHour, sMinute), calculateTime(eHour, eMinute));
    }

    public void workingTime(String name, String sHour, String sMinute, String eHour, String eMinute) {
        this.workingTime = new TimeSlot(name, calculateTime(sHour, sMinute), calculateTime(eHour, eMinute));
    }
}
