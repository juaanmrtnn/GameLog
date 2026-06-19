/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.GameTrackController;
import java.util.List;
import model.entity.GameTrack;
import model.persistence.GameTrackDAO;
import model.persistence.JDBC.GameTrackDAOJDBC;

/**
 *
 * @author juanito
 */
public class GameTrackModelImpl implements GameTrackModel {
    
    private GameTrackController controller;

    @Override
    public GameTrackController getController() {
        return controller;
    }

    @Override
    public void setController(GameTrackController controller) {
        this.controller = controller;
    }

    @Override
    public void setTrack(GameTrack track) {
        GameTrackDAO dao = new GameTrackDAOJDBC();
        dao.create(track);
        this.controller.fireDataModelChanged();
    }

    @Override
    public GameTrack getTrack(int id) {
        GameTrackDAO dao = new GameTrackDAOJDBC();
        return dao.read(id);
    }

    @Override
    public void updateTrack(GameTrack track) {
        GameTrackDAO dao = new GameTrackDAOJDBC();
        dao.update(track);
        this.controller.fireDataModelChanged();
    }

    @Override
    public void deleteTrack(GameTrack track) {
        GameTrackDAO dao = new GameTrackDAOJDBC();
        dao.delete(track);
        this.controller.fireDataModelChanged();
    }

    @Override
    public List<GameTrack> listTracks() {
        GameTrackDAO dao = new GameTrackDAOJDBC();
        return dao.list();
    }
    
    
}
