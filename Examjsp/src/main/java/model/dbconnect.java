package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnect {
    private String jdbcURL = "jdbc:mysql://localhost:3306/student_management?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static Connection connection = null;

    protected Connection getConnection() {
        if(connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
                System.out.println("GET DATABASE CONNECTION SUCCESS");
            } catch (Exception e) {
                System.out.println("GET DATABASE CONNECTION FAILED");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
