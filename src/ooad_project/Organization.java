/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_project;

import java.util.*;

/**
 *
 * @author Acer
 */
public class Organization {
    List<Team> T_list;      //List of treams
    List<Donor> D_list;     //List of Donors
    List<Project> P_list;   //List of projects

    public Organization(List<Team> T_list, List<Donor> D_list, List<Project> P_list) {
        this.T_list = T_list;
        this.D_list = D_list;
        this.P_list = P_list;
    }

    public Organization() {
        T_list = new ArrayList<>();
        D_list = new ArrayList<>();
        P_list = new ArrayList<>();
    }

    public void addTeam(Team T_list) {
        this.T_list.add(T_list);
    }

    public void addDonor(Donor D_list) {
        this.D_list.add(D_list);
    }

    public void addProject(Project P) {
        this.P_list.add(P);
    }

    public void print()
    {
    System.out.println("**This is the Organization**");
    
    System.out.println("List of Teams");
    for(Team T : T_list)
    {
        
    System.out.println(T.getName());
    
    }
    
    System.out.println("\nList of Donors: ");
    for(Donor d : D_list)
    {
        System.out.println(d.Name);
    }
    
    
    
    System.out.println("\nList of Projects: ");
    for(Project P : P_list)
    {
        System.out.println(P.getProject_Name());
    }
    
    
    
    }
    
    
    

}










