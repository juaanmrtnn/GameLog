/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.util.List;
import model.PlatformModel;
import model.entity.Platform;

/**
 *
 * @author juanito
 */
public interface PlatformController {
    
    public PlatformModel getModel();
    
    public void setModel(PlatformModel model);
    
    // bind model to view
    public void setup(PlatformModel model);
            
    public Platform getPlatformGesture(String id);
    
    public List<Platform> listPlatformsGesture();
    
}
