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
public class Fund {
 List<Donor> D_List;        // List of Donors   
 List<Project>  P_List;        //List of projects

    public Fund(List<Donor> D_List, List<Project> P_List) {
        this.D_List = D_List;
        this.P_List = P_List;
    }

    public List<Donor> getD_List() {
        return D_List;
    }

    public List<Project> getP_List() {
        return P_List;
    }

 
 

}
