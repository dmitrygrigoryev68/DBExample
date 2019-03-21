package de.telran.grigoryev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) throws Exception{
        String dbUser = "root";
        String dbPassword = "11111111";
        String connectionURL = "jdbc:mysql://localhost:3306/users";
        System.out.println(connectionURL);

        Connection connection = DriverManager.getConnection(connectionURL,dbUser,dbPassword);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

        while(resultSet.next()){
            System.out.println(resultSet.getString("password"));
        }

    }
}
