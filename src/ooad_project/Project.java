/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_project;

/**
 *
 * @author Acer
 */
public class Project {
    String Project_Name;
    Volunteer Manager;
    String description;
    int budget;

    public String getManagerName() {
        return Manager.Name;
    }

    public String getDescription() {
        return description;
    }

    public int getBudget() {
        return budget;
    }

    public Team getTeam() {
        return team;
    }
    Team team;          // team assigned to this project

    public Project(String Project_Name, Volunteer Manager, String description, int budget) {
        this.Project_Name = Project_Name;
        this.Manager = Manager;
        this.description = description;
        this.budget = budget;
    }

    public void allocateTeam(Team t)
    {
        this.team = team;
    }
    public String getProject_Name() {
        return Project_Name;
    }
    
    
    
}
