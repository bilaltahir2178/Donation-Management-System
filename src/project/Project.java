package project;

import interview.Interview;
import java.util.ArrayList;
import people.Donor;
import people.Subject;
import people.Volunteer;

public class Project {

    private int id;
    private String name;
    private ArrayList<Subject> people = null;
    private ArrayList<Donor> donors = null;
    private ArrayList<Volunteer> volunteers = null;
    private Interview interview = null;
    private ArrayList<Pledge> pledges = null;

    Project(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void addDonor(Donor donor) {
        if(donors==null){
            donors=new ArrayList<>();
            donors.add(donor);
        }
    }

    void addSubject(String name, int age, String cnic, String address) {
        if (people == null) {
            people = new ArrayList<>();
            Subject subject = new Subject(name, age, cnic, address);
            people.add(subject);
        } else {
            Subject subject = new Subject(name, age, cnic, address);
            people.add(subject);
        }
    }

    void addVolunteer(String name, int age, String cnic, String address, int workingHours, String startingHour1, String startingMinute1, String endingHour1, String endingMinuute1, String startingHour2, String startingMinute2, String endingHour2, String endingMinuute2) {
        if (volunteers == null) {
            volunteers = new ArrayList<>();
            Volunteer volunteer = new Volunteer(name, age, cnic, address, workingHours);
            volunteer.setAvailibility(name, startingHour1, startingMinute1, endingHour1, endingMinuute1);
            volunteer.workingTime(name, startingHour2, startingMinute2, endingHour2, endingMinuute2);
            volunteers.add(volunteer);
        } else {
            Volunteer volunteer = new Volunteer(name, age, cnic, address, workingHours);
            volunteer.setAvailibility(name, startingHour1, startingMinute1, endingHour1, endingMinuute1);
            volunteer.workingTime(name, startingHour2, startingMinute2, endingHour2, endingMinuute2);
            volunteers.add(volunteer);
        }
    }

    void addInterview(Interview interview) {
        this.interview = interview;
    }

    void addPledge(int id, String projectName, Donor donor, String description) {
        if (pledges == null) {
            pledges = new ArrayList<>();
            Pledge pledge = new Pledge(id, projectName, donor, description);
            pledges.add(pledge);
        } else {
            Pledge pledge = new Pledge(id, projectName, donor, description);
            pledges.add(pledge);
        }
    }
}
