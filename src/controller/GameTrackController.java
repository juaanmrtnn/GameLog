/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.util.List;
import model.GameTrackModel;
import model.entity.GameTrack;
import view.gametrack.GameTrackTableModel;
import view.gametrack.GameTrackView;

/**
 *
 * @author juanito
 */
public interface GameTrackController {
    
    public GameTrackModel getModel();
    
    public void setModel(GameTrackModel model);
    
    // bind model to view
    public void setup(GameTrackModel model, GameTrackTableModel tableModel, List<GameTrackView> views);
    
    public void start();
    
    public void addView(GameTrackView view);
    
    public void removeView(GameTrackView view);
    
    public void setTrackGesture(String userId, String gameId, String platformId, String progress, String playedHours);
    
    public GameTrack getTrackGesture(String id);
    
    public void updateTrackGesture(String id, String userId, String gameId, String platformId, String progress, String playedHours);
    
    public void deleteTrackGesture(String id, String userId, String gameId, String platformId, String progress, String playedHours);
    
    public List<GameTrack> listTracksGesture();
    
    public void fireDataModelChanged();
}
