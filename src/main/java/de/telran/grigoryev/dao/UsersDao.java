package de.telran.grigoryev.dao;

import de.telran.grigoryev.model.User;

import java.util.List;

public interface UsersDao extends CrudDao <User>{

    List<User> findAllByFirstName();
}
