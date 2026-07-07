package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		

        String url = "jdbc:mysql://localhost:3306/automationdb";
        String username = "root";
        String password = "Srinivas@2027";
        
        try {

            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Database Connected Successfully!");

            con.close();

            System.out.println("Connection Closed.");

        } catch (Exception e) {

            e.printStackTrace();
        }

	}

}
