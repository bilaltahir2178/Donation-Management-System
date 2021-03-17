/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_project;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Farwa
 */
public class dbConnectivity 
{
    Connection con;
    Statement stmt;

    public dbConnectivity() //cons
    {
        try
        {
             String s = "jdbc:sqlserver://localhost:1433;databaseName=donations";
             con=DriverManager.getConnection(s,"root","12345678");


            stmt = con.createStatement(); 

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public ArrayList<String> getProjectNames()
    {
        ArrayList<String> names = new ArrayList<>();
        try{
           ResultSet rs = stmt.executeQuery("select nam from project");
           while(rs.next())
           {
               names.add(rs.getString(1));
           }
        }
           catch(Exception e)
                   {
                       System.out.println(e); 
                  // names = null;
                   }
        return names;
    }
    
    public ArrayList<String> getvolunteerNames()
    {
        ArrayList<String> names = new ArrayList<>();
        try{
           ResultSet rs = stmt.executeQuery("select nam from volunteer where avail = 1");
           while(rs.next())
           {
               names.add(rs.getString(1));
           }
        }
           catch(Exception e)
                   {
                       System.out.println(e); 
                  // names = null;
                   }
        return names;
    }
    
    public int selectbeneficiary(String project,String beneficiary)
    {
        int x= 0;
        try{
        CallableStatement Stmt = con.prepareCall("{call addbeneficiaryprojects (?,?)}");
            Stmt.setString(1,project);
            Stmt.setString(2,beneficiary);
            Stmt.executeUpdate();
            Stmt.close();        
         }
         catch(SQLException e)
         {
             x=1;
             e.printStackTrace();
         }
    return x;
    }
    
    public int selectteam(String project , String volunteer)
    {
       int x= 0;
        try{
        CallableStatement Stmt = con.prepareCall("{call addprojectvolunteers (?,?)}");
            Stmt.setString(1,project);
            Stmt.setString(2,volunteer);
            Stmt.executeUpdate();
            Stmt.close();        
         }
         catch(SQLException e)
         {
             x=1;
             e.printStackTrace();
         }
    return x; 
    }
    
    public int checkname(String name)
    {
         int q=0; 
        try{
        ResultSet rs = stmt.executeQuery("select count(nam) from project where nam like '"+name+"'");
        while(rs.next())
          q= rs.getInt(1);
         }
         catch(SQLException e)
         {
             e.printStackTrace();
         }
         return q;
    }
    public int checkMName(String name)
    {
        int q=0; 
        try{
        ResultSet rs = stmt.executeQuery("select count(nam) from project where manager like '"+name+"'");
        while(rs.next())
          q= rs.getInt(1);
         }
         catch(SQLException e)
         {
             e.printStackTrace();
         }
         return q;
    }
    //getProjectByMN------------------------------------------------------------
    public Project getProjectByMN(String n)
    {
        Project p=null;
        int budget=0,xx=0;
        String name=null,desc=null,managername=null;
         try{
            ResultSet rs = stmt.executeQuery("select * from project where manager like '"+n+"'");
            while(rs.next())
            {
            name = rs.getString(1);
            desc = rs.getString(2);
            managername = rs.getString(3);
            budget= rs.getInt(4);
            }
            Volunteer v = getManager(managername);
            p = new Project(name,v,desc,budget);
         }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        return p;
    }
    
    public int addDonation(Donation d)
    {
     int xx=0; 
         try{
            CallableStatement Stmt = con.prepareCall("{call addDonation(?,?,?,?)}");
            Stmt.setString(1,d.project);
            Stmt.setString(2,d.donor);
            Stmt.setString(3,d.donationType);
            Stmt.setInt(4,d.amount);
            Stmt.executeUpdate();
            Stmt.close();
            }
            catch(SQLException e)
            {
                xx=1;
                e.printStackTrace();
            }
        return xx;
    }
    
        public String getname (String cnic)
        {
            String name=null;
            try{
           ResultSet rs = stmt.executeQuery("select nam from donor where cnic like '"+cnic+"'");
           while(rs.next())
           {
               name = (rs.getString(1));
           }
        }
           catch(Exception e)
                   {
                       System.out.println(e); 
                       name = null;
                   }
            return name;
        }
        public String getbeneficiaryname (String cnic)
        {
            String name=null;
            try{
           ResultSet rs = stmt.executeQuery("select nam from beneficiary where cnic like '"+cnic+"'");
           while(rs.next())
           {
               name = (rs.getString(1));
           }
        }
           catch(Exception e)
                   {
                       System.out.println(e); 
                       name = null;
                   }
            return name;
        }
       public ArrayList<String> getDonorProjects(String n)
       {
           ArrayList<String> names = new ArrayList<>();
        try{
           ResultSet rs = stmt.executeQuery("select project from donation where donor like '"+n+"'");
           while(rs.next())
           {
               names.add(rs.getString(1));
           }
        }
           catch(Exception e)
                   {
                       System.out.println(e); 
                        names = null;
                   }
        return names;
       }
       
       public ArrayList<String> getBeneficiaries()
       {
           ArrayList<String> names = new ArrayList<>();
        try{
           ResultSet rs = stmt.executeQuery("select nam from Beneficiary");
           while(rs.next())
           {
               names.add(rs.getString(1));
           }
        }
           catch(Exception e)
                   {
                       System.out.println(e); 
                        names = null;
                   }
        return names;           
       }
       public ArrayList<String> getBeneficiaryProjects(String n)
       {
           ArrayList<String> names = new ArrayList<>();
        try{
           ResultSet rs = stmt.executeQuery("select project from beneficiaryprojects where beneficiary like '"+n+"'");
           while(rs.next())
           {
               names.add(rs.getString(1));
           }
        }
           catch(Exception e)
                   {
                       System.out.println(e); 
                        names = null;
                   }
        return names;
       }
    public ArrayList<String> getBeneficiaryList()
    { 
         ArrayList<String> names = new ArrayList<>();
        try{
           ResultSet rs = stmt.executeQuery("select nam from donor");
           while(rs.next())
           {
               names.add(rs.getString(1));
           }
        }
           catch(Exception e)
                   {
                       System.out.println(e); 
                  // names = null;
                   }
        return names;
        
    }
    public int getdonorweight(String n)
    {
       int weight=0;
        try{
            ResultSet rs = stmt.executeQuery("select sum(amount) from donation where donor like '"+n+"' and dontype like 'wheat'");
            while(rs.next())
            {
                weight += rs.getInt(1);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return weight;
    }
    
    public int getbeneficiaryweight(String n)
    {
       int weight=0;
        try{
            ResultSet rs = stmt.executeQuery("select sum(weight) from issuedonations where beneficiary like '"+n+"'");
            while(rs.next())
            {
                weight += rs.getInt(1);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return weight;
    }
    
    
    public int getdonorprojectweight(String n,String p)
    {
       int weight=0;
        try{
            ResultSet rs = stmt.executeQuery("select sum(amount) from donation where donor like '"+n+"' and project like '"+p+"' and dontype like 'wheat'");
            while(rs.next())
            {
                weight += rs.getInt(1);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return weight;
    }
    
    
    public int getdonorprojectamount(String n, String p)
    {
       int weight=0;
        try{
            ResultSet rs = stmt.executeQuery("select sum(amount) from donation where donor like '"+n+"' and project like '"+p+"' and dontype like 'cash'");
            while(rs.next())
            {
                weight += rs.getInt(1);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return weight;
    }
    
    
    
    public int getbeneficiaryprojectweight(String n,String p)
    {
       int weight=0;
        try{
            ResultSet rs = stmt.executeQuery("select sum(weight) from issuedonations where beneficiary like '"+n+"' and project like '"+p+"'");
            while(rs.next())
            {
                weight += rs.getInt(1);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return weight;
    }
    
    
    public int getbeneficiaryprojectamount(String n,String p)
    {
       int amount=0;
        try{
            ResultSet rs = stmt.executeQuery("select sum(amount) from issuedonations where beneficiary like '"+n+"' and project like '"+p+"'");
            while(rs.next())
            {
                amount += rs.getInt(1);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return amount;
    }
    
    
    
    
    public Donor getDonorFull(String cnic)
    {
        Donor d=null,d2=null;
        String n = getname(cnic);
        ArrayList<String> projects = getDonorProjects(n);
        int amount=0,weight=0;
        weight=getdonorweight(n);
        try{
            ResultSet rs = stmt.executeQuery("select sum(amount) from donation where donor like '"+n+"' and dontype like 'cash'");
            while(rs.next())
            {
                amount += rs.getInt(1);
            }
            d = getDonor(cnic);
            d2 = new Donor(projects,amount,weight,d.Name,d.CNIC,d.Address,d.Phone,d.DOB);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return d2;
    }
    public ArrayList<String> getDonorsList()
    {
        ArrayList <String> a=new ArrayList<>();
        try{
            ResultSet rs = stmt.executeQuery("select nam from donor");
            while(rs.next())
            {
                a.add(rs.getString(1));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return a;
    }
    public Beneficiary getBeneficiaryFull(String cnic)
    {
        Beneficiary d=null,d2=null;
        String n = getbeneficiaryname(cnic);
        ArrayList<String> projects = getBeneficiaryProjects(n);
        int amount=0,weight=0;
        weight=getbeneficiaryweight(n);
        try{
            ResultSet rs = stmt.executeQuery("select sum(amount) from issuedonations where beneficiary like '"+n+"'");
            while(rs.next())
            {
                amount += rs.getInt(1);
            }
            d = getBeneficiary(cnic);
            d2 = new Beneficiary(projects,amount,weight,d.Name,d.CNIC,d.Address,d.Phone,d.DOB);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return d2;
    }
    
    public Beneficiary getBeneficiary(String cnic)
    {
        Beneficiary d=null;
        String name=null,cnic2=null,address=null,phone = null,dob = null;
         try{
            ResultSet rs = stmt.executeQuery("select * from beneficiary where cnic like '"+cnic+"'");
            while(rs.next())
            {
            name = rs.getString(1);
            cnic2 = rs.getString(2);
            address = rs.getString(3);
            phone = rs.getString(4);
            dob = rs.getString(5);
            }
            d = new Beneficiary(name,cnic,address,phone,dob);
         }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        return d;
    }
    
    public Donor getDonor(String cnic)
    {
    Donor d=null;
        String name=null,cnic2=null,address=null,phone = null,dob = null;
         try{
            ResultSet rs = stmt.executeQuery("select * from donor where cnic like '"+cnic+"'");
            while(rs.next())
            {
            name = rs.getString(1);
            cnic2 = rs.getString(2);
            address = rs.getString(3);
            phone = rs.getString(4);
            dob = rs.getString(5);
            }
            d = new Donor(name,cnic,address,phone,dob);
         }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        return d;
    }
    
    public void updatevolunteer(String name)
    {
        int q=0;
        try{
        ResultSet rs = stmt.executeQuery("update volunteer set avail = 0 where nam like '"+name+"'");
        while(rs.next())
            q=rs.getInt(1);
         }
         catch(SQLException e)
         {
             e.printStackTrace();
         }
    }
    
    public int addProject(Project p)
    {
         int xx=0; 
         try{
            xx = checkname(p.Project_Name);
            if(xx == 0)
            {
            updatevolunteer(p.Manager.Name);
            CallableStatement Stmt = con.prepareCall("{call addProject(?,?,?,?)}");
            Stmt.setString(1,p.Project_Name);
            Stmt.setString(2,p.description);
            Stmt.setString(3,p.Manager.Name);
            Stmt.setInt(4,p.budget);
            Stmt.executeUpdate();
            Stmt.close();
            }
         }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        return xx;
    }
    
     public int addDonor(Donor d)
    {
         int xx=0; 
         try{
            CallableStatement Stmt = con.prepareCall("{call addDonor(?,?,?,?,?)}");
            Stmt.setString(1,d.Name);
            Stmt.setString(2,d.Phone);
            Stmt.setString(3,d.Address);
            Stmt.setString(4,d.CNIC);
            Stmt.setString(5,d.DOB);               
            Stmt.executeUpdate();
            Stmt.close();
            }
            catch(SQLException e)
            {
                xx = 1;
                e.printStackTrace();
            }
        return xx;
    }
     
     public int addBeneficiary(Beneficiary b)
    {
         int xx=0; 
         try{
            CallableStatement Stmt = con.prepareCall("{call addBeneficiary(?,?,?,?,?)}");
            Stmt.setString(1,b.Name);
            Stmt.setString(2,b.Phone);
            Stmt.setString(3,b.Address);
            Stmt.setString(4,b.CNIC);
            Stmt.setString(5,b.DOB);               
            Stmt.executeUpdate();
            Stmt.close();
            }
            catch(SQLException e)
            {
                xx = 1;
                e.printStackTrace();
            }
        return xx;
    }
    
    public Project getProject(String n)
    {
        Project p=null;
        int budget=0,xx=0;
        String name=null,desc=null,managername=null;
         try{
            ResultSet rs = stmt.executeQuery("select * from project where nam like '"+n+"'");
            while(rs.next())
            {
            name = rs.getString(1);
            desc = rs.getString(2);
            managername = rs.getString(3);
            budget= rs.getInt(4);
            }
            Volunteer v = getManager(managername);
            p = new Project(name,v,desc,budget);
         }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        return p;
    }    
    public Volunteer getManager(String name)
    {
        Volunteer v=null;
        int budget,xx=0;
        String n=null,cnic,address,phone,dob;
        int x = 0;
         try{
            ResultSet rs = stmt.executeQuery("select * from volunteer where nam like '"+name+"'");
            while(rs.next())
            {
            n = rs.getString(1);
            cnic = rs.getString(2);
            address = rs.getString(3);
            phone = rs.getString(4);
            dob = rs.getString(5);
            v = new Volunteer(true,n,cnic,address,phone,dob);
            }
         }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        return v;
    }
    public int addVolunteer(Volunteer v)
    {
        
       int xx=0; 
         try{
            CallableStatement Stmt = con.prepareCall("{call addVolunteer(?,?,?,?,?,?)}");
            Stmt.setBoolean(1,true);
            Stmt.setString(2,v.Name);
            Stmt.setString(3,v.CNIC);
            Stmt.setString(4,v.Address);
            Stmt.setString(5,v.Phone);
            Stmt.setString(6,v.DOB);
            Stmt.executeUpdate();
            Stmt.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                xx=1;
            }
        return xx;
    }
    
    public ArrayList getManagerNames()
    {
        ArrayList <String> managers = new ArrayList<>();
           String name;
         try{
            ResultSet rs = stmt.executeQuery("select nam from volunteer where avail = 1");
            while(rs.next())
            {
            managers.add(rs.getString(1));
            }
         }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        return managers;
    }
}
