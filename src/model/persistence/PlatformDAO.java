/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.persistence;

import java.util.List;
import model.entity.Platform;

/**
 *
 * @author juanito
 */
public interface PlatformDAO {
    
    public Platform read(int id);
    
    public List<Platform> list();
    
}
