package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable 
{

	public static void main(String[] args)
	{
		    String url = "jdbc:mysql://localhost:3306/automationdb";
	        String username = "root";
	        String password = "Srinivas@2027";
	        
	        try 
	        {

	            Connection con = DriverManager.getConnection(url, username, password);
	            Statement stmt = con.createStatement();
	            
	            String query = "CREATE TABLE Employee ("
	                    + "id INT PRIMARY KEY,"
	                    + "name VARCHAR(100),"
	                    + "salary DOUBLE)";
	            
	            stmt.executeUpdate(query);
	            
	            System.out.println("Table Created Successfully");
	            
	            stmt.close();
	            con.close();
	            
	            
	        }
	        catch(Exception e)
	        {
	        	 e.printStackTrace();
	        }

	}

}
