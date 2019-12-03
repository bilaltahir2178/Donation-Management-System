package newpackage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import people.Donor;
import people.Subject;
import people.Volunteer;
import project.Project;

public class DbConnectivity {

    Connection connection;
    Statement statement;

    public DbConnectivity() //Constructor
    {
        try {
            String s = "jdbc:sqlserver://localhost:1433;databaseName=Donation";
            connection = DriverManager.getConnection(s, "sa", "12345678");

            statement = connection.createStatement();
//             String s = "jdbc:sqlserver://localhost:1433;databaseName=donations";
//             connection = DriverManager.getConnection(s,"sa","12345678");
//
//            statement = connection.createStatement(); 

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<String> getProjectNames() {
        ArrayList<String> names = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery("SELECT name from Project");
            while (rs.next()) {
                names.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println(e);
            // names = null;
        }
        return names;
    }

    public int addProject(Project p) {
        try {
            ResultSet rs = statement.executeQuery("SELECT COUNT([Project].[Name]) FROM [Project] WHERE [Project].[Name] = " + p.getName());
            rs.next();
            int count = rs.getInt(1);
            if(count == 0) {
                String sqlStatement = "INSERT INTO [Project](ID, Name, Description, ManagerID, Budget) VALUES (";
                sqlStatement += p.getId() + ", ";
                sqlStatement += "'" + p.getName() + "'" + ", ";
                sqlStatement += "'" + p.getDescription() + "'" + ", ";
                sqlStatement += p.getManager().mId + ", ";
                sqlStatement += p.getBudget() + ");";
                statement.executeUpdate(sqlStatement);
                return 1;
            }
            else
                return 0;
        }
        catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public int allocateTeam(List<Volunteer> volunteers, int teamID, int teamLeadId) {
        try {
            ResultSet rs = statement.executeQuery("SELECT COUNT([Team].[ID]) FROM [Team] WHERE [Team].[ID] = " + teamID);
            rs.next();
            int count = rs.getInt(1);
            if(count == 0) {
                for(int i = 0; i < volunteers.size(); i++) {
                    String sqlStatement = "INSERT INTO [Team] VALUES (";
                    sqlStatement += teamID + ", ";
                    sqlStatement += volunteers.get(i).mId + ", ";
                    if(teamLeadId == volunteers.get(i).mId)
                        sqlStatement += 1 + ");";
                    else
                        sqlStatement += 0 + ");";
                    statement.executeUpdate(sqlStatement);
                }
                return 1;
            }
            return 0;
        }
        catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    
    public int addTeamMember(int teamId, int memberId) {
        try {
            ResultSet rs = statement.executeQuery("SELECT COUNT([Team].[PersonID]) FROM [Team] WHERE [Team].[PersonID] = " + memberId);
            rs.next();
            int count = rs.getInt(1);
            if(count == 0) {
                String sqlStatement = "INSERT INTO [Team] VALUES (";
                sqlStatement += teamId + ", ";
                sqlStatement += memberId + ", ";
                sqlStatement += 0 + ");";
                statement.executeUpdate(sqlStatement);
                return 1;
            }
            else
                return 0;
        }
        catch(Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    
    public int removeTeamMember(int teamId, int memberId) {
        try {
            ResultSet rs = statement.executeQuery("SELECT COUNT([Team].[PersonID]) FROM [Team] WHERE [Team].[PersonID] = " + memberId);
            rs.next();
            int count = rs.getInt(1);
            if(count != 0) {
                String sqlStatement = "DELETE FROM [Team] WHERE [PersonID] = " + memberId;
                statement.executeUpdate(sqlStatement);
                return 1;
            }
            else
                return 0;
        }
        catch(Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    
    public int updateTeamMember(int teamId, int oldMemberId, int newMemberId) {
        try {
            ResultSet rs = statement.executeQuery("SELECT COUNT([Team].[PersonID]) FROM [Team] WHERE [Team].[PersonID] = " + oldMemberId);
            rs.next();
            int count = rs.getInt(1);
            if(count != 0) {
                String sqlStatement = "UPDATE [Team] SET [PersonID] = " + newMemberId + " WHERE [PersonID] = " + oldMemberId;
                statement.executeUpdate(sqlStatement);
                return 1;
            }
            else
                return 0;
        }
        catch(Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    
    public int addDonor(int donorID, int donationID, int pledgeID, String pledgeDescription) {
        try {
            ResultSet rs = statement.executeQuery("SELECT COUNT([Donor].[PersonID]) FROM [Donor] WHERE [Donor].[PersonID] = " + donorID);
            rs.next();
            int count = rs.getInt(1);
            if(count != 0) {
                String sqlStatement = "INSERT INTO [Donor] VALUES (" + donorID + ", " + donationID + ", " + pledgeID + ");";
                statement.executeUpdate(sqlStatement);
                
                String sqlStatement2 = "INSERT INTO [Pledge] VALUES (" + pledgeID + ", " + pledgeDescription + ");";
                statement.executeUpdate(sqlStatement2);
                return 1;
            }
            else
                return 0;
        }
        catch(Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    
    public int checkname(String name) {
        int q = 0;
        try {
            ResultSet rs = statement.executeQuery("select count(nam) from project where nam like '" + name + "'");
            while (rs.next()) {
                q = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return q;
    }

    public int checkMName(String name) {
        int q = 0;
        try {
            ResultSet rs = statement.executeQuery("select count(nam) from project where manager like '" + name + "'");
            while (rs.next()) {
                q = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return q;
    }

    //getProjectByMN------------------------------------------------------------
    public Project getProjectByMN(String n) {
        Project p = null;
        int budget = 0, xx = 0;
        String name = null, desc = null, managername = null;
        try {
            ResultSet rs = statement.executeQuery("select * from project where manager like '" + n + "'");
            while (rs.next()) {
                name = rs.getString(1);
                desc = rs.getString(2);
                managername = rs.getString(3);
                budget = rs.getInt(4);
            }
            Volunteer v = getManager(managername);
            //      p = new Project(name, v, desc, budget);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public void updatevolunteer(String name) {
        int q = 0;
        try {
            ResultSet rs = statement.executeQuery("update volunteer set avail = 0 where nam like '" + name + "'");
            while (rs.next()) {
                q = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int addDonor(Donor d) {
        int xx = 0;
        try {
            CallableStatement Stmt = connection.prepareCall("{call addDonor(?,?,?,?,?)}");
            Stmt.setString(1, d.mName);
            Stmt.setString(2, d.mPhone);
            Stmt.setString(3, d.mAddress);
            Stmt.setString(4, d.mCnic);
            Stmt.setString(5, d.mDateOfBirth);
            Stmt.executeUpdate();
            Stmt.close();
        } catch (SQLException e) {
            xx = 1;
            e.printStackTrace();
        }
        return xx;
    }

    public int addSubject(Subject b) {
        int xx = 0;
        try {
            CallableStatement Stmt = connection.prepareCall("{call addSubject(?,?,?,?,?)}");
            Stmt.setString(1, b.mName);
            Stmt.setString(2, b.mPhone);
            Stmt.setString(3, b.mAddress);
            Stmt.setString(4, b.mCnic);
            Stmt.setString(5, b.mDateOfBirth);
            Stmt.executeUpdate();
            Stmt.close();
        } catch (SQLException e) {
            xx = 1;
            e.printStackTrace();
        }
        return xx;
    }

    public Project getProject(String n) {
        Project p = null;
        int budget = 0, xx = 0;
        String name = null, desc = null, managername = null;
        try {
            ResultSet rs = statement.executeQuery("select * from project where nam like '" + n + "'");
            while (rs.next()) {
                name = rs.getString(1);
                desc = rs.getString(2);
                managername = rs.getString(3);
                budget = rs.getInt(4);
            }
            Volunteer manager = getManager(managername);
            //    p = new Project(name, manager, desc, budget);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public Volunteer getManager(String name) {
        Volunteer mVolunteer = null;
        String mName = null, mCnic = null, mAddress = null, mPhone = null, mDateOfBirth = null;
        int x = 0;
        try {
            ResultSet rs = statement.executeQuery("select * from volunteer where nam like '" + name + "'");
            while (rs.next()) {
                mName = rs.getString(1);
                mCnic = rs.getString(2);
                mAddress = rs.getString(3);
                mPhone = rs.getString(4);
                mDateOfBirth = rs.getString(5);
                //mVolunteer = new Volunteer(true, mName, mCnic, mAddress, mPhone, mDateOfBirth);
            }
            // x = rs.getInt(6);
            // if(x == 1)
            // else
            // v = new Volunteer(false,n,cnic,address,phone,dob);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mVolunteer;
    }

    public int addVolunteer(Volunteer v) {

        int xx = 0;
        try {
            CallableStatement Stmt = connection.prepareCall("{call addVolunteer(?,?,?,?,?,?)}");
            Stmt.setBoolean(1, true);//Volunteer is always available in the start
            Stmt.setString(2, v.mName);
            Stmt.setString(3, v.mCnic);
            Stmt.setString(4, v.mAddress);
            Stmt.setString(5, v.mPhone);
            Stmt.setString(6, v.mDateOfBirth);
            Stmt.executeUpdate();
            Stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            xx = 1;
        }
        return xx;
    }

    public ArrayList getManagerNames() {
        ArrayList<String> managers = new ArrayList<>();
        String name;
        try {
            ResultSet rs = statement.executeQuery("select nam from volunteer where avail = 1");
            while (rs.next()) {
                managers.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return managers;
    }

    /*
     boolean deleteMedicine(String n)
     {
     boolean r;
     try
     {
     CallableStatement Stmt = connection.prepareCall("{call deleteMedicine(?)}");
     Stmt.setString(1,n);
     Stmt.executeUpdate();
     Stmt.close();
     r = true ;
     }
     catch(Exception e)
     {  
     System.out.println(e);
     r=false;
     }
     return r;
     }
     boolean decreaseQuantity(String n)
     {
     boolean r=false;
     int q=-1;
     try{
     ResultSet rs = statement.executeQuery("select medQuantity from medicineinfo where medName like '"+n+"'");
     while(rs.next())
     {
     q= rs.getInt(1);
     }
     if(q != -1 && q != 0)
     {
     q--;
     try
     {
     statement.executeUpdate("update medicineinfo set medQuantity ='"+Integer.toString(q)+"' where medName like '"+n+"'");
     r=true;
     }
     catch(Exception e)
     {
     System.out.println(e);
     r=false;
     }
     }
     }
     catch(Exception e)
     {
     System.out.println(e);
     r=false;
     }
     return r;
     }

     */
}
