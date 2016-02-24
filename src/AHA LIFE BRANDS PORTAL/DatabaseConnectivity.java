package AHALIFEBRANDSPORTAL;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DatabaseConnectivity extends GenericClass{
    
    public void DatabaseAndQueryConfiguration(HashMap<String, String> databaseQuery) throws SQLException, ClassNotFoundException
    {
	   String dbUrl = "jdbc:mysql://bp01.qa.ahalife.com:3306/onboarding";                   
       String username = "onboarding";           
       String password = "cV3qz2W4a";             
       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection(dbUrl,username,password);
       String query = databaseQuery.get("DatabaseQuery");
       String columnName = databaseQuery.get("ColumnName");
       QueryExecution(query,columnName);
       con.close();
    }
    
    
    public void QueryExecution(String query,String columnName);
    {
       String query = query;
       Statement stmt = con.createStatement();                    
       ResultSet rs= stmt.executeQuery(query);     
       rs.next();
       String actualName = rs.getString(columnName);  
       System.out.println(actualName);     
    }
    
    
    
    
    public void storeFrontClick(HashMap<String, String> storeFront) throws SQLException, ClassNotFoundException
    {
       //Retrieving the data from database created.
	   String dbUrl = "jdbc:mysql://bp01.qa.ahalife.com:3306/onboarding";                   
       String username = "onboarding";           
       String password = "cV3qz2W4a";             
       //Load My SQL Server jdbc driver        
       Class.forName("com.mysql.jdbc.Driver");         
       //Create Connection to DB       
       Connection con = DriverManager.getConnection(dbUrl,username,password);
        
       String query = "SELECT EMAILS FROM admin_query where ID = 1;";
       Statement stmt = con.createStatement();                    
       ResultSet rs= stmt.executeQuery(query);     
       rs.next();
       String actualName = rs.getString("EMAILS");  
       System.out.println(actualName);   
       con.close();  
    }
}