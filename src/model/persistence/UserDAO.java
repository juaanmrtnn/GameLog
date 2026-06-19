/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.persistence;

import java.util.List;
import model.entity.User;

/**
 *
 * @author juanito
 */
public interface UserDAO {
    
    public void create(User user);
    
    public User read(int id);
    
    public User readByUsername(String username);
    
    public void update(User user);
    
    public void delete(User user);
    
    public List<User> list();
}
