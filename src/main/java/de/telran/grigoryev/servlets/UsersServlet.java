/*package de.telran.grigoryev.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

//@WebServlet("/addUser")
public class UsersServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(getServletContext()
                    .getRealPath("/WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUserName = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String dbDriverClassName = properties.getProperty("db.driverClassName");

            Class.forName(dbDriverClassName);

            connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getServletContext()
                .getRequestDispatcher("/jsp/addUser.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");

        try {
           Statement statement = connection.createStatement();
            String sqlInsert = "INSERT INTO user (first_name,last_name)" +
                    " VALUES ('" + firstName + "','" + lastName + "');";
            statement.execute(sqlInsert);
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO user(first_name,last_name) VALUES (?,?)");
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException();
        }
    }
}
*/