package de.telran.grigoryev.servlets;


import de.telran.grigoryev.dao.UsersDao;
import de.telran.grigoryev.dao.UsersDaoJdbcImpl;
import de.telran.grigoryev.model.User;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@WebServlet("/users")
public class UsersDaoServlet extends HttpServlet {
    private UsersDao usersDao;

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(getServletContext()
                    .getRealPath("/WEB-INF/classes/db.properties")));

            String dbUrl = properties.getProperty("db.url");
            String dbUserName = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String dbDriverClassName = properties.getProperty("db.driverClassName");

            dataSource.setUsername(dbUserName);
            dataSource.setPassword(dbPassword);
            dataSource.setUrl(dbUrl);
            dataSource.setDriverClassName(dbDriverClassName);

            usersDao = new UsersDaoJdbcImpl(dataSource);
            System.out.println(dataSource.toString());

        } catch (IOException e) {
            throw new IllegalAccessError();


        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {



        List<User> users = usersDao.findAll();
        req.setAttribute("usersFromServer", users);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/users.jsp");
        dispatcher.forward(req, resp);

    }
}
