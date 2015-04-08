/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import model.BugD;

/**
 *
 * @author anamdev
 */
public class DbCom
{
    public static final String dbuser = "root";
    public static final String dbpwd = "amd@123";
    public static final String database = "bugbasket";
    //public static final String dburl = "jdbc:mysql://192.168.0.103/";
    public static final String dburl = "jdbc:mysql://localhost/";
    private static final String dbDriver = "com.mysql.jdbc.Driver";
    
    public static void loadDbDriver()
    {
        try
        {
            Class.forName(dbDriver);
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println("Can not load Driver class : "+cnfe.getMessage());
        }
    }
    
    public static Connection createConnection() throws SQLException
    {
        Connection connection = null;
        connection = DriverManager.getConnection(dburl+database+"?user="+dbuser+"&password="+dbpwd);
        System.out.println(dburl+database+"?user="+dbuser+"&password="+dbpwd);
        if(connection==null)
        {
            throw new NullPointerException();
        }
        return connection;
    }
}