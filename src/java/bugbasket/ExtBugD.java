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
 * 
 * class to extract bug details from BugD model and sets the indivisual count fields
 * of different bugs on the basis of status
 */
public class ExtBugD
{
    private int totalBug;
    private int openBug;
    private int closedBug;
    private int triagedBug;
    private int implementedBug;
    private int analyzedBug;
    private int needMoreInfoQA;

    public int getTotalBug() {
        return totalBug;
    }

    public void setTotalBug(int totalBug) {
        this.totalBug = totalBug;
    }

    public int getOpenBug() {
        return openBug;
    }

    public void setOpenBug(int openBug) {
        this.openBug = openBug;
    }

    public int getClosedBug() {
        return closedBug;
    }

    public void setClosedBug(int closedBug) {
        this.closedBug = closedBug;
    }

    public int getTriagedBug() {
        return triagedBug;
    }

    public void setTriagedBug(int triagedBug) {
        this.triagedBug = triagedBug;
    }

    public int getImplementedBug() {
        return implementedBug;
    }

    public void setImplementedBug(int implementedBug) {
        this.implementedBug = implementedBug;
    }

    public int getAnalyzedBug() {
        return analyzedBug;
    }

    public void setAnalyzedBug(int analyzedBug) {
        this.analyzedBug = analyzedBug;
    }

    public int getNeedMoreInfoQA() {
        return needMoreInfoQA;
    }

    public void setNeedMoreInfoQA(int needMoreInfoQA) {
        this.needMoreInfoQA = needMoreInfoQA;
    }

    public ExtBugD(int totalBug, int openBug, int closedBug, int triagedBug, int implementedBug, int analyzedBug, int needMoreInfoQA)
    {
        this.totalBug = totalBug;
        this.openBug = openBug;
        this.closedBug = closedBug;
        this.triagedBug = triagedBug;
        this.implementedBug = implementedBug;
        this.analyzedBug = analyzedBug;
        this.needMoreInfoQA = needMoreInfoQA;
    }
    
    public ExtBugD()
    {
        this.totalBug = 0;
        this.openBug = 0;
        this.closedBug = 0;
        this.triagedBug = 0;
        this.implementedBug = 0;
        this.analyzedBug = 0;
        this.needMoreInfoQA = 0;
    }
    
    public ArrayList<BugD> extractBugDetails(String user)
    {
        ArrayList<BugD> bugdList = null;
        int open ,closed,triaged,implemented,analyzed,nmi;
        Query query = new Query();
        query.setActionBy(user);
        query.fetchBugData();
        bugdList = query.getBugdList();
        
        open  = closed = triaged = implemented = analyzed = nmi = 0;
        for(BugD bugd : bugdList)
        {
            switch(bugd.getStatus())
            {
                case "open":
                    open++;
                    break;
                case "closed":
                    closed++;
                    break;
                case "implemented":
                    implemented++;
                    break;
                case "need more info - qa":
                    nmi++;
                    break;
                case "triaged":
                    triaged++;
                    break;
                case "analyzed":
                    analyzed++;
                    break;
            }
        }
        this.setOpenBug(open);
        this.setClosedBug(closed);
        this.setImplementedBug(implemented);
        this.setNeedMoreInfoQA(nmi);
        this.setTriagedBug(triaged);
        this.setAnalyzedBug(analyzed);
        this.setTotalBug(bugdList.size());
        return bugdList;
    }  
}
