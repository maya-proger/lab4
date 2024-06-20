package org.majic.services;

import org.majic.daos.UserDao;
import org.majic.models.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    private UserDao userDao = new UserDao();

    public UserService() {
    }

    public Optional<User> findUser(int id) {
        Optional<User> user = Optional.empty();
        try{
            user = userDao.findById(id);
        } catch(SQLException e){
            System.out.println("Exception: " + e.getMessage());
        }
        return user;
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public void deleteUser(Long id) {
        userDao.delete(id);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        try{
            users = userDao.findAll();
        } catch(SQLException e){
            System.out.println("Exception: " + e.getMessage());
        }
        return users;
    }
}