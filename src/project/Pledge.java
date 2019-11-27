package project;

import people.Donor;

public class Pledge {

    private int id;
    private String projectName;
    private Donor donor;
    private String description;

    public Pledge(int id, String projectName, Donor donor, String description) {
        this.id = id;
        this.projectName = projectName;
        this.donor = donor;
        this.description = description;
    }
}
