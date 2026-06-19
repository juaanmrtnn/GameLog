/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import controller.UserController;
import java.util.List;
import model.entity.User;

/**
 *
 * @author juanito
 */
public interface UserModel {
    
    public UserController getController();
    
    public void setController(UserController controller);
    
    public void setUser(User user);
    
    public User getUser(int id);
    
    public User getUserByUsername(String username);
    
    public void updateUser(User user);
    
    public void deleteUser(User user);
    
    public List<User> listUsers();
}
