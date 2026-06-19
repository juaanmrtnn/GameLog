/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.PlatformModel;
import model.entity.Platform;

/**
 *
 * @author juanito
 */
public class PlatformControllerImpl implements PlatformController {
    
    private PlatformModel model;

    @Override
    public PlatformModel getModel() {
        return model;
    }

    @Override
    public void setModel(PlatformModel model) {
        this.model = model;
    }

    @Override
    public void setup(PlatformModel model) {
        this.setModel(model);
        model.setController(this);
    }

    @Override
    public Platform getPlatformGesture(String id) {
        return this.model.getPlatform(Integer.parseInt(id));
    }

    @Override
    public List<Platform> listPlatformsGesture() {
        return this.model.listPlatforms();
    }
    
    
}
