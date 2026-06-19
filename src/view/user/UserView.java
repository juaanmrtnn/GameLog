/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view.user;

import controller.UserController;

/**
 *
 * @author juanito
 */
public interface UserView {
    
    public UserController getController();
    
    public void setController(UserController controller);
}
