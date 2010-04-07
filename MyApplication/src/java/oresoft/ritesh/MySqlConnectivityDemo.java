/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oresoft.ritesh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Ritesh Kumar
 */
public class MySqlConnectivityDemo {
    public static void main(String[] args) throws Exception
    {
        Connection connection = null;
        try
        {
            // Here we load the MySQL database Driver class
            Class.forName("com.mysql.jdbc.Driver");

            // Define properties for connecting to database such as
            // database jdbc url, username and password
            String url = "jdbc:mysql://localhost/test";
            String username = "root";
            String password = "ritesh";

            // Get a connection to database.
            connection = DriverManager.getConnection(url, username, password);
            
            java.sql.Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from student");
            while(rs.next())
            {
                int x=rs.getInt(1);
                String str1=rs.getString(2);
                String str2=rs.getString(3);
                System.out.println(x+" "+str1+" "+str2);
            }

            //connection.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
      System.err.println("Exception: " + e.getMessage());
        }
 //connection.close();
       }
}