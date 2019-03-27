package de.telran.grigoryev.dao;

import de.telran.grigoryev.model.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersDaoJdbcImpl implements UsersDao {


    private final String SQL_SELECT_ALL = "SELECT * FROM user";
    private final String SQL_SELECT_BY_ID = "SELECT * FROM user WHERE user_id = ?";
    private Connection connection;


    public UsersDaoJdbcImpl(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException();
        }

    }

    @Override
    public List<User> findAllByFirstName() {
        return null;
    }

    @Override
    public Optional<User> find(Integer id) {
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                return Optional.of(new User(id, firstName, lastName));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException();
        }
    }


    @Override
    public void save(User model) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<User> findAll() {
        try {
            List<User> users = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

            while (resultSet.next()) {
                Integer id = resultSet.getInt("user_id");
                String firstName = resultSet.getString("first_name");
                String lastName =  resultSet.getString("last_name");

                User user = new User(id, firstName, lastName);

                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new IllegalStateException();
        }
    }
}
