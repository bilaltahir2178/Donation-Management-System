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
public class Beneficiary extends Person{
    ArrayList<Project> B_Projects;
    public ArrayList <String> projectlist;
    public int amount;
    public int weight;
    Donation D;
    public Beneficiary(ArrayList<Project> B_ProjetLs) {
        this.B_Projects = B_ProjetLs;
    }
    public Beneficiary(String Name, String CNIC, String Address, String Ph, String age) {
        super(Name, CNIC, Address, Ph, age);
    }    
    public Beneficiary(ArrayList <String> p , int am , int wt,String Name, String CNIC, String Address, String Ph, String age) {
        super(Name, CNIC, Address, Ph, age);
        this.projectlist=p;
        this.amount=am;
        this.weight=wt;
    }
    void showProjectlist()
    {
            for(Project P : B_Projects)
            {
                System.out.println(P.getProject_Name());
            }
    }
}
