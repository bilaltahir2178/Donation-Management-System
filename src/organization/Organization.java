package organization;

import funds.Funds;
import people.Donor;
import people.Founder;
import java.util.ArrayList;
import project.Pledge;
import project.Project;

public class Organization {
    private String name;
    private ArrayList<Founder> founders;
    private ArrayList<Funds> funds;
    private ArrayList<Donor> donors;
    private ArrayList<Pledge> pledges;
    private ArrayList<Project> projectsActive;
    private ArrayList<Project> projectsDone;    
    
    Organization(String name){
        this.name=name;
        this.founders=new ArrayList<>();
        this.funds=new ArrayList<>();
        this.donors=new ArrayList<>();
        this.pledges=new ArrayList<>();
        this.projectsActive=new ArrayList<>();
        this.projectsDone=new ArrayList<>();
    }
    
    public void addFounder(Founder founder){
        this.founders.add(founder);
    }
    
    public void addDonor(Donor donor){
        this.donors.add(donor);
    }
    
    public void addPledge(Pledge pledge){
        this.pledges.add(pledge);
    }
    
    public void makeProjectActive(Project project){
        this.projectsActive.add(project);
    }
    
    public void makeProjectDone(Project project){
        this.projectsDone.add(project);
    }
}
