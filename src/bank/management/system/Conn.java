package bank.management.system;

import java.sql.*;

public class Conn {
    // Declare the connection and statement
    Connection c;
    Statement s;

    // Constructor to establish the connection
    public Conn() {
        try {
          
            Class.forName("com.mysql.cj.jdbc.Driver");

           
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "12345#abcdE");
            
           
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);  // Print the exception if any
        }
    }

    
    public void close() {
        try {
            if (s != null) s.close(); 
            if (c != null) c.close(); 
        } catch (SQLException e) {
            System.out.println("Error while closing the resources: " + e);
        }
    }
}
