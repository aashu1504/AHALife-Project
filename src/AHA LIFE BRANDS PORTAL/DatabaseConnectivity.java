package AHA LIFE BRANDS PORTAL;

import java.util.*;

class DatabaseConnectivity{
    
    public void storeFrontClick(HashMap<String, String> storeFront)
    {
       //Retrieving the data from database created.
	   String dbUrl = "jdbc:mysql://localhost:1433;databaseName=DummyDatabase;instance=SQLEXPRESS";                   
       String username = "sa";           
       String password = "may@2015";             
       //Load SQL Server jdbc driver        
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");         
       //Create Connection to DB       
       Connection con = DriverManager.getConnection(dbUrl,username,password);
       String query = "select CustomerName from Customers where CustomerID = 1;";    
       Statement stmt = con.createStatement();                    
       ResultSet rs= stmt.executeQuery(query);     
       rs.next();
       String actualName = rs.getString("CustomerName");  
       System.out.println(actualName);
      // while (rs.next()){
               //     String id = rs.getString(1);                                        
                //    String lastName = rs.getString(2);  
                //    String firstName = rs.getString(3);  
                //    String address = rs.getString(4);  
               //     String city = rs.getString(5);  
               //     String postalCode = rs.getString(6);  
               //     String country = rs.getString(7);
                //    System. out.println(id +"  "+lastName+"  "+firstName+"  "+address+"  "+city+ " " + postalCode + " " + country);     
          //  }          
       con.close();  
    }
}