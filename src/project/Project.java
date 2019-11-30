package project;

import interview.Interview;
import java.util.ArrayList;
import people.Donor;
import people.Subject;
import people.Volunteer;

public class Project {

    private int id;
    private String name;
    private String description;
    private Volunteer manager;
    private int budget;
    public int teamID = 1;
    public ArrayList<Subject> people = null;
    public ArrayList<Donor> donors = null;
    public ArrayList<Volunteer> volunteers = null;
    public ArrayList<Pledge> pledges = null;

    public Project(int id, String name, Volunteer manager, String desc, int budget) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.description = desc;
        this.budget = budget;
    }

    void addDonor(Donor donor) {
        if (donors == null) {
            donors = new ArrayList<>();
            donors.add(donor);
        }
    }

    void addSubject(String name, String cnic, String address, String phone, String dateOfBirth) {
        if (people == null) {
            people = new ArrayList<>();
            //Subject subject = new Subject(name, cnic, address, phone, dateOfBirth);
          //  people.add(subject);
        } else {
         //   Subject subject = new Subject(name, cnic, address, phone, dateOfBirth);
          //  people.add(subject);
        }
    }

    void addVolunteer(Boolean availability, String name, int age, String cnic, String address, String phone, String dateOfBirth, String startingHour1, String startingMinute1, String endingHour1, String endingMinuute1, String startingHour2, String startingMinute2, String endingHour2, String endingMinuute2) {
        if (volunteers == null) {
            volunteers = new ArrayList<>();
           // Volunteer volunteer = new Volunteer(availability, name, cnic, address, phone, dateOfBirth);
       //     volunteer.setAvailibility(name, startingHour1, startingMinute1, endingHour1, endingMinuute1);
       //     volunteer.workingTime(name, startingHour2, startingMinute2, endingHour2, endingMinuute2);
        //    volunteers.add(volunteer);
        } else {
          //  Volunteer volunteer = new Volunteer(availability, name, cnic, address, phone, dateOfBirth);
          //  volunteer.setAvailibility(name, startingHour1, startingMinute1, endingHour1, endingMinuute1);
          //  volunteer.workingTime(name, startingHour2, startingMinute2, endingHour2, endingMinuute2);
          //  volunteers.add(volunteer);
        }
    }

    void addInterview(Interview interview) {
//        this.interview = interview;
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Volunteer getManager() {
        return manager;
    }

    public int getBudget() {
        return budget;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setManager(Volunteer manager) {
        this.manager = manager;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
