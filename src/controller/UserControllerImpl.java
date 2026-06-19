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
import view.user.UserView;

/**
 *
 * @author juanito
 */
public class UserControllerImpl implements UserController {
    
    private UserModel model;
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
    public void setup(UserModel model, List<UserView> views) {
        this.setModel(model);
        model.setController(this);
        
    }

    @Override
    public void start() {
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
    public void setUserGesture(String id, String username, String email) {
        User u = new UserImpl(Integer.parseInt(id), username, email);
        this.model.setUser(u);
        this.fireDataModelChanged();
    }

    @Override
    public User getUserGesture(String id) {
        return this.model.getUser(Integer.parseInt(id));
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
        for (UserView v: this.views) {
            v.display();
        }
    }
    
    
    
}
