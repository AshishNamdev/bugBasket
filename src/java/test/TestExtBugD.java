/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import bugbasket.ExtBugD;

/**
 *
 * @author anamdev
 */
public class TestExtBugD
{
    public static void main(String[] args) {
        String actionBy = "anamdev";
        ExtBugD extractBug = new ExtBugD();
        extractBug.extractBugDetails(actionBy);
        
        System.out.println("total bugs : "+extractBug.getTotalBug());
        System.out.println("open bugs : "+extractBug.getOpenBug());
        System.out.println("closed bugs : "+extractBug.getClosedBug());
        System.out.println("implemented bugs : "+extractBug.getImplementedBug());
        System.out.println("triaged bugs : "+extractBug.getTriagedBug());
        System.out.println("AnalyzedBug bugs : "+extractBug.getAnalyzedBug());
        System.out.println("NeedMoreInfoQA bugs : "+extractBug.getNeedMoreInfoQA());
    }
}
