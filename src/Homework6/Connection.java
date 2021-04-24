package Homework6;

import java.sql.*;

public class Connection {

    private static java.sql.Connection connection;

    public java.sql.Connection getConnection() {

        if (connection == null) {
            String url = "jdbc:mysql://127.0.0.1:3306/todo";
            String user = "java";
            String password = "option123";
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("Connection failed");
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }
}