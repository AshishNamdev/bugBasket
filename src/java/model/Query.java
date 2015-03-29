/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import comm.DbCom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author anamdev
 */
public class Query
{
    ArrayList<BugD> bugdList = new ArrayList<BugD>();
    private String actionBy;

    public String getActionBy()
    {
        return "\""+actionBy+"\" ";
    }

    public ArrayList<BugD> getBugdList() {
        return bugdList;
    }
    public void setActionBy(String actionBy) {
        this.actionBy = actionBy;
    }
      
    public void getBugData()
    {
        String query = "SELECT * FROM `bugbasket`.`bugd` where actionby = "+this.getActionBy();
        System.out.println(query);
        DbCom.loadDbDriver();
        try
        {
            Connection connection = DbCom.createConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultset = ps.executeQuery();
            
            while(resultset.next())
            {
                BugD bugd = new BugD();
                bugd.setBugID(resultset.getString("bugid"));
                bugd.setTitle(resultset.getString("title"));
                bugd.setBugDate(resultset.getDate("bugdate"));
                bugd.setLastModified(resultset.getDate("lastmodified"));
                bugd.setCreator(resultset.getString("creator"));
                bugd.setPriority(resultset.getString("priority"));
                bugd.setStatus(resultset.getString("status"));
                bugd.setActionBy(resultset.getString("actionby"));
                
                this.bugdList.add(bugd);
            }
        }
        catch(NullPointerException npe)
        {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, npe);
            System.out.println("createConnection():can not create connection to database : "+npe.getMessage());
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("sql error : "+ex.getMessage());
        }   
    }   
}