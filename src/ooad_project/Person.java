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
public class Person {
    String Name;
    String CNIC;
    String Address;
    String Phone;
    String DOB;

    
    // Default Constructor
    public Person() {
    }
    
    // Parameterized Constructor
    public Person(String Name, String CNIC, String Address, String Ph,String dob) {
        this.Name = Name;
        this.CNIC = CNIC;
        this.Address = Address;
        this.Phone = Ph;
        this.DOB = dob;
    }
    //Print Function
    void Print()
    {
    System.out.println("Name:          " + this.Name);
    System.out.println("CNIC:          " + this.CNIC);
    System.out.println("Address:       " + this.Address);
    System.out.println("Phone Number:  " + this.Phone);
    System.out.println("Date of Birth: " + this.DOB);
    
    
    }
    
    
    /* ---------  Getters  ----------*/
    public String getName() {
        return Name;
    }

    public String getCNIC() {
        return CNIC;
    }

    public String getAddress() {
        return Address;
    }

    public String getPh() {
        return Phone;
    }

    public String getDOB() {
        return DOB;
    }

    /* ---------  Setters  ----------*/
     
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setPh(String Ph) {
        this.Phone = Ph;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

   
}
