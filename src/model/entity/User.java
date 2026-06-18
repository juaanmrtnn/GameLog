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
    
    public String getId();

    public void setId(String id);

    public String getEmail();

    public void setEmail(String email);
    
    public String toString();
}
