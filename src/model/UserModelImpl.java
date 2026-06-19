/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.UserController;
import java.util.List;
import model.entity.User;
import model.persistence.JDBC.UserDAOJDBC;
import model.persistence.UserDAO;

/**
 *
 * @author juanito
 */
public class UserModelImpl implements UserModel {
    
    private UserController controller;

    @Override
    public UserController getController() {
        return controller;
    }

    @Override
    public void setController(UserController controller) {
        this.controller = controller;
    }

    @Override
    public void setUser(User user) {
        UserDAO dao = new UserDAOJDBC();
        dao.create(user);
        this.controller.fireDataModelChanged();
    }

    @Override
    public User getUser(int id) {
        UserDAO dao = new UserDAOJDBC();
        return dao.read(id);
    }
    
    @Override
    public User getUserByUsername(String username) {
        UserDAO dao = new UserDAOJDBC();
        return dao.readByUsername(username);
    }

    @Override
    public void updateUser(User user) {
        UserDAO dao = new UserDAOJDBC();
        dao.update(user);
        this.controller.fireDataModelChanged();
    }

    @Override
    public void deleteUser(User user) {
        UserDAO dao = new UserDAOJDBC();
        dao.delete(user);
        this.controller.fireDataModelChanged();
    }

    @Override
    public List<User> listUsers() {
        UserDAO dao = new UserDAOJDBC();
        return dao.list();
    }
    
    
}
