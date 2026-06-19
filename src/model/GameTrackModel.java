/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import controller.GameTrackController;
import java.util.List;
import model.entity.GameTrack;

/**
 *
 * @author juanito
 */
public interface GameTrackModel {
    
    public GameTrackController getController();
    
    public void setController(GameTrackController controller);
    
    public void setTrack(GameTrack track);
    
    public GameTrack getTrack(int id);
    
    public void updateTrack(GameTrack track);
    
    public void deleteTrack(GameTrack track);
    
    public List<GameTrack> listTracks();
}
