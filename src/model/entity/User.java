/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.entity;

import java.io.Serializable;

/**
 *
 * @author juanito
 */
public interface User extends Serializable {
    
    public int getId();

    public void setId(int id);

    public String getUsername();
    
    public void setUsername(String username);
    
    public String getEmail();

    public void setEmail(String email);
    
    public String toString();
}
