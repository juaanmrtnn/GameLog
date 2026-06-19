/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import controller.PlatformController;
import java.util.List;
import model.entity.Platform;

/**
 *
 * @author juanito
 */
public interface PlatformModel {
    
    public PlatformController getController();
    
    public void setController(PlatformController controller);
    
    public Platform getPlatform(int id);
    
    public List<Platform> listPlatforms();
    
}
