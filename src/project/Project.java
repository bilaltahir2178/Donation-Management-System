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
public class Project {
    private int id;
    private String name;
    private ArrayList<Subject> people;
    private ArrayList<Volunteer> voluntteers;
    private Interview interview;
    private ArrayList<Pledge> pledges;
    
    Project(int id, String name){
        this.id=id;
        this.name=name;
    }
}
