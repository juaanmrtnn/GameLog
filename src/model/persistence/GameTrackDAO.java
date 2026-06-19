/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.persistence;

/**
 *
 * @author juanito
 */
public interface GameTrackDAO {
    
    public void create(User user);
    
    public User read(int id);
    
    public void update(User user);
    
    public void delete(User user);
    
    public List<User> list();
}
