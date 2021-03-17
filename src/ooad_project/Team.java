/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_project;
import java.util.*;

/**
 *
 * @author Usama Rizwan
 */
public class Team {
    String name;
    List<Volunteer> V_list;     //List of volunteers
    Volunteer head;             // Head of team
    Project project;            //Project of this team

    public Team() {
    }

    public Team(String name, List<Volunteer> V_list, Volunteer head, Project project) {
        this.name = name;
        this.V_list = V_list;
        this.head = head;
        this.project = project;
    }
    /*  --------- all getter -------*/
    public String getName() {
        return name;
    }

    public List<Volunteer> getV_list() {
        return V_list;
    }

    public Volunteer getHead() {
        return head;
    }

    public Project getProject() {
        return project;
    }
    /*--------------- all setter/adders ---------------*/
    public void setName(String name) {
        this.name = name;
    }

    public void setV_list(List<Volunteer> V_list) {
        this.V_list = V_list;
    }

    public void setHead(Volunteer head) {
        this.head = head;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    
    public void addMember(Volunteer V)
    {
            this.V_list.add(V);
    }
    public void removeMember( Volunteer V)
    {
                Boolean r = this.V_list.remove(V);
                if(r == false)
                {
                    System.out.println("The Volunteer " + V.Name + " is not member of " + this.name + " Team");
                }
    }
    
    public void replaceMember(Volunteer R , Volunteer N)
    {
        Boolean B = true;
            for(Volunteer V : this.V_list)
            {
                if(V.CNIC.equals(R.CNIC))
                {
                    V_list.remove(R);
                    V_list.add(N);
                    B = false;
                }
            }
            if(B == true)
            {
                    System.out.println("The Volunteer " + R.Name + " is not a member of " + this.name + " Team"); 
            }
    }
}






























