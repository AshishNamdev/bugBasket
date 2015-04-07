/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import bugbasket.ExtBugD;
import comm.DbCom;
import java.util.ArrayList;
import model.BugD;
import bugbasket.Query;

/**
 *
 * @author anamdev
 */
public class TestBugD
{
    public static void main(String[] args)
    {
        String actionBy = "anamdev";
        Query query = new Query();
        query.setActionBy(actionBy);
        query.fetchBugData();
        ArrayList<BugD> bugdList = query.getBugdList();
        //System.out.println("bugid \t\t\t title \t\t\t\t\t\t\t\t\t\t bugdate lastmodified \t creator \t\t Priority \t status \t actioby");
        for(BugD bugd : bugdList)
            System.out.println("\n"+bugd.getBugID() +" \t "+ bugd.getTitle()+" \t "+bugd.getBugDate()+" \t "+bugd.getLastModified()+" \t "+bugd.getCreator()+" \t "+bugd.getPriority()+" \t "+bugd.getStatus()+" \t "+bugd.getActionBy());
    }
}
