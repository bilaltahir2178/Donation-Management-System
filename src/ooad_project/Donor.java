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
public class Donor extends Person{
    List<Project> P_List;   // Project List
    List<Fund> F_List;  // Fund List
    public ArrayList<String> ProjectNames;
    public int amount,weight;
    
    public Donor(List<Project> P_List, List<Fund> F_List, String Name, String CNIC, String Address, String Ph, String age) {
        super(Name, CNIC, Address, Ph, age);
        this.P_List = P_List;
        this.F_List = F_List;
    }
     public Donor(String Name, String CNIC, String Address, String Ph, String age) {
        super(Name, CNIC, Address, Ph, age);
    }
     public Donor(ArrayList<String> p , int amount , int weight,String Name, String CNIC, String Address, String Ph, String age) {
        super(Name, CNIC, Address, Ph, age);
        this.ProjectNames=p;
        this.amount=amount;
        this.weight=weight;
    }
     public int getamount()
     {
         return amount;
     }
     public int getweight()
     {
         return weight;
     }
    void print()
    {
        super.Print();
        System.out.println("\nList of Projects: ");
        for(Project i : P_List)
        {   
            System.out.println(i.getProject_Name());
        }
    }
    
}
