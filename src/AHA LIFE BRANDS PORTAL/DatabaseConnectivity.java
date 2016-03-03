package AHALIFEBRANDSPORTAL;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DatabaseConnectivity{
    
    public void DatabaseAndQueryConfiguration(HashMap<String, String> databaseQuery) throws SQLException, ClassNotFoundException
    {
	   String dbUrl = databaseQuery.get("DatabaseURL");            
       String username = databaseQuery.get("UserName");     
       String password = databaseQuery.get("Password");         
       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection(dbUrl,username,password);
       String query = databaseQuery.get("DatabaseQuery");
		System.out.println(query);
       String columnName = databaseQuery.get("ColumnName");
       QueryExecution(query,columnName,con);
       con.close();
    }
    
    
    public String QueryExecution(String query,String columnName,Connection con) throws SQLException, ClassNotFoundException
    {
       Statement stmt = con.createStatement();                    
       ResultSet rs= stmt.executeQuery(query);     
       rs.next();
       String data = rs.getString(columnName);  
       System.out.println(data);   
       return data;
    }
}