/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import funds.Funds;
import java.util.ArrayList;
import people.Donor;
import people.Subject;
import people.Volunteer;
import project.Project;

/**
 *
 * @author bilal
 */
public class BusinessLogic {

    DbConnectivity myDb;

    public BusinessLogic() {
        myDb = new DbConnectivity();
    }

    public int addProject(Project p) {
        return myDb.addProject(p);
    }
    
    public int allocateTeam(String name) {
        return 0;
    }
    
    public void addMember(){
    }
    public void removeMember(){
    }
    public void replaceMember(){
    }
    
    public int addDonor(Donor d) {
        return myDb.addDonor(d);
    }
    
    public void addFunds(Funds funds){
        
    }
    
    public ArrayList<String> getProjectNames() {
        return (myDb.getProjectNames());
    }

    public int checkPName(String N) {
        return myDb.checkname(N);
    }

    public Project getProject(String n) {
        return myDb.getProject(n);
    }

    public int addSubject(Subject b) {
        return myDb.addSubject(b);
    }

    public Volunteer getManager(String name) {
        Volunteer v = myDb.getManager(name);
        return v;
    }

    public int addVolunteer(Volunteer v) {
        return myDb.addVolunteer(v);
    }

    public ArrayList getManagerNames() {
        return myDb.getManagerNames();
    }

    public int checkMName(String MN) {
        return myDb.checkMName(MN);
    }

    public Project getProjectByMN(String MN) {
        return myDb.getProjectByMN(MN);
    }
}
