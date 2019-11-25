package project;

import people.Volunteer;
import people.Subject;
import interview.Interview;
import java.util.ArrayList;

public class Project {
    private int id;
    private String name;
    private ArrayList<Subject> people;
    private ArrayList<Volunteer> voluntteers;
    private Interview interview;
    private ArrayList<Pledge> pledges;
    
    Project(int id, String name){
        this.id=id;
        this.name=name;
    }
}
