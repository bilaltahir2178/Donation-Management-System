/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;

/**
 *
 * @author bilal
 */
public class DonationManagementSystem {
    private String name;
    private ArrayList<Organization> organizations;
    
    DonationManagementSystem(String name){
        this.name=name;
        this.organizations=new ArrayList<>();
    }
    
    public void addOrganization(Organization organization){
        this.organizations.add(organization);
    }
}
