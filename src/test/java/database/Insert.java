package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert {


	    public static void main(String[] args) {

	        String url = "jdbc:mysql://localhost:3306/automationdb";
	        String username = "root";
	        String password = "Srinivas@2027";

	        try {

	            // Step 1: Connect to DB
	            Connection con = DriverManager.getConnection(url, username, password);

	            // Step 2: Create Statement
	            Statement stmt = con.createStatement();

	            // Step 3: Insert Query
	            String query = "INSERT INTO Employee (id, name, salary) VALUES (1, 'Srinivas', 50000)";

	            // Step 4: Execute Query
	            int rows = stmt.executeUpdate(query);

	            System.out.println(rows + " Record Inserted Successfully");

	            // Step 5: Close connection
	            stmt.close();
	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}