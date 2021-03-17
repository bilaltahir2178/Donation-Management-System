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
public class Goods {
    String Item;
    int Qnt;
    List<Project> P_List;       //List of projects for which donor donated

    public Goods(String Item, int Qnt, List<Project> P_List) {
        this.Item = Item;
        this.Qnt = Qnt;
        this.P_List = P_List;
    }

    public String getItem() {
        return Item;
    }

    public int getQnt() {
        return Qnt;
    }

    public List<Project> getP_List() {
        return P_List;
    }
    
    
    
}
