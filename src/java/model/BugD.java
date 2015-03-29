/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author anamdev
 */
public class BugD
{
    private String bugID;
    private String title;
    private Date bugDate;
    private Date lastModified;
    private String  creator;
    private String priority;
    private String status;
    private String actionBy;

    public BugD()
    {
        this.bugID = null;
        this.title = null;
        this.bugDate = null;
        this.lastModified = null;
        this.creator = null;
        this.priority = null;
        this.status = null;
        this.actionBy = null;
    }
    public BugD(String bugID, String title, Date bugDate, Date lastModified, String creator, String priority, String status, String actionBy)
    {
        this.bugID = bugID;
        this.title = title;
        this.bugDate = bugDate;
        this.lastModified = lastModified;
        this.creator = creator;
        this.priority = priority;
        this.status = status;
        this.actionBy = actionBy;
    }

    public String getBugID()
    {
        return bugID;
    }

    public void setBugID(String bugID)
    {
        this.bugID = bugID;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Date getBugDate()
    {
        return bugDate;
    }

    public void setBugDate(Date bugDate)
    {
        this.bugDate = bugDate;
    }

    public Date getLastModified()
    {
        return lastModified;
    }

    public void setLastModified(Date lastModified)
    {
        this.lastModified = lastModified;
    }

    public String getCreator()
    {
        return creator;
    }

    public void setCreator(String creator)
    {
        this.creator = creator;
    }

    public String getPriority()
    {
        return priority;
    }

    public void setPriority(String priority)
    {
        this.priority = priority;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getActionBy()
    {
        return actionBy;
    }

    public void setActionBy(String actionBy)
    {
        this.actionBy = actionBy;
    }
}