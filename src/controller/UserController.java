/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.util.List;
import model.UserModel;
import model.entity.User;
import view.user.UserView;

/**
 *
 * @author juanito
 */
public interface UserController {
    
    public UserModel getModel();
    
    public void setModel(UserModel model);
    
    // bind model to view
    public void setup(UserModel model, List<UserView> views);
    
    public void start();
    
    public void addView(UserView view);
    
    public void removeView(UserView view);
    
    public void setUserGesture(String id, String username, String email);
    
    public User getUserGesture(String id);
    
    public User getUserByUsernameGesture(String username);
    
    public void updateUserGesture(String id, String username, String email);
    
    public void deleteUserGesture(String id, String username, String email);
    
    public List<User> listUsersGesture();
    
    public void fireDataModelChanged();
    
}
