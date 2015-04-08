/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugbasket;

import java.util.ArrayList;
import model.BugD;

/**
 *
 * @author anamdev
 */
public class BugView
{
    private String bugStatus;

    public void setBugStatus(String bugStatus)
    {
        this.bugStatus = bugStatus;
    }

    public String getBugStatus()
    {
        return bugStatus;
    }
    
    
    public ArrayList<BugD> prepareView(ArrayList<BugD> bugdList)
    {
        ArrayList<BugD> bugFilter = new ArrayList<BugD>();
        for(BugD bugd : bugdList)
        {
            if(bugd.getStatus().equalsIgnoreCase(this.bugStatus))
            {
                System.out.println(bugd);
                bugFilter.add(bugd);
            }
        }
        return bugFilter;
    }
}
