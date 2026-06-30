/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.UserModel;
import model.entity.User;
import model.entity.UserImpl;
import view.gametrack.UserComboModel;
import view.user.UserTableModel;
import view.user.UserView;

/**
 *
 * @author juanito
 */
public class UserControllerImpl implements UserController {
    
    private UserModel model;
    private UserTableModel tableModel;
    private UserComboModel comboModel;
    private List<UserView> views;
    
    public UserControllerImpl(){
        this.views = new ArrayList<>();
    }

    @Override
    public UserModel getModel() {
        return model;
    }

    @Override
    public void setModel(UserModel model) {
        this.model = model;
    }

    @Override
    public void setup(UserModel model, UserTableModel tableModel, UserComboModel comboModel, List<UserView> views) {
        this.setModel(model);
        this.tableModel = tableModel;
        this.comboModel = comboModel;
        model.setController(this);
        this.addViews(views);
        
    }

    @Override
    public void start() {
        List<User> users = this.model.listUsers();
        this.tableModel.setUsers(users);
        this.comboModel.setUsers(users);
        
        for(UserView view : views){
            view.display();
        }
    }

    @Override
    public void addView(UserView view) {
        view.setController(this);
        this.views.add(view);
    }
    
    public void addViews(List<UserView> views){
        for(UserView v : views){
            this.addView(v);
        }
    }

    @Override
    public void removeView(UserView view) {
        this.views.remove(view);
    }

    @Override
    public void setUserGesture(String username, String email) {
        User u = new UserImpl(username, email);
        this.model.setUser(u);
        this.fireDataModelChanged();
    }

    @Override
    public User getUserGesture(String id) {
        return this.model.getUser(Integer.parseInt(id));
    }
    
    @Override
    public User getUserByUsernameGesture(String username) {
        return this.model.getUserByUsername(username);
    }

    @Override
    public void updateUserGesture(String id, String username, String email) {
        User u = new UserImpl(Integer.parseInt(id), username, email);
        this.model.updateUser(u);
        this.fireDataModelChanged();
    }

    @Override
    public void deleteUserGesture(String id, String username, String email) {
        User u = new UserImpl(Integer.parseInt(id), username, email);
        this.model.deleteUser(u);
        this.fireDataModelChanged();
    }

    @Override
    public List<User> listUsersGesture() {
        return this.model.listUsers();
    }

    @Override
    public void fireDataModelChanged() {
        List<User> users = this.model.listUsers();
        this.tableModel.setUsers(users);
        this.comboModel.setUsers(users);
        for (UserView v: this.views) {
            v.display();
        }
    }
    
    
    
}
