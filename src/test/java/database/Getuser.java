package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Getuser {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/automationdb";
        String username = "root";
        String password = "Srinivas@2027";

        try {

            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            String query = "SELECT * FROM users";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                int id = rs.getInt("id");
                String user = rs.getString("username");
                String email = rs.getString("email");
                String pass = rs.getString("password");

                System.out.println(id + " " + user + " " + email + " " + pass);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}