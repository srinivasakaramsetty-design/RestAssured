package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateConnection {

    public static void main(String[] args) 
    {

        String url = "jdbc:mysql://localhost:3306/automationdb";
        String username = "root";
        String password = "Srinivas@2027";

        try {

            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            String query = "UPDATE users SET username='Srinu', email='srinu@gmail.com', password='srinu123' WHERE id=1";

            int rows = stmt.executeUpdate(query);

            if (rows > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("No user found.");
            }

            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}