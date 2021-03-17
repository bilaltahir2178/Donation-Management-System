/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_project;

import java.util.Date;

/**
 *
 * @author Acer
 */
public class Volunteer extends Person{
    
    Boolean avail;
    // Default and parameterized
    public Volunteer(Boolean avail, String Name, String CNIC, String Address, String Ph, String dob) {
        super(Name, CNIC, Address, Ph, dob);
        this.avail = avail;
    }
    
    
}
