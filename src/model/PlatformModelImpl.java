/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.PlatformController;
import java.util.List;
import model.entity.Platform;
import model.persistence.PlatformDAO;
import model.persistence.JDBC.PlatformDAOJDBC;

/**
 *
 * @author juanito
 */
public class PlatformModelImpl implements PlatformModel {
    
    private PlatformController controller;

    @Override
    public PlatformController getController() {
        return controller;
    }

    @Override
    public void setController(PlatformController controller) {
        this.controller = controller;
    }

    @Override
    public Platform getPlatform(int id) {
        PlatformDAO dao = new PlatformDAOJDBC();
        return dao.read(id);
    }

    @Override
    public List<Platform> listPlatforms() {
        PlatformDAO dao = new PlatformDAOJDBC();
        return dao.list();
    }
    
    
}
