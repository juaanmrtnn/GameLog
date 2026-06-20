/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import model.GameTrackModel;
import model.entity.GameImpl;
import model.entity.GameTrack;
import model.entity.GameTrackImpl;
import model.entity.PlatformImpl;
import model.entity.UserImpl;
import view.gametrack.GameTrackView;

/**
 *
 * @author juanito
 */
public class GameTrackControllerImpl implements GameTrackController {
    
    private GameTrackModel model;
    private List<GameTrackView> views;
    
    public GameTrackControllerImpl(){
        this.views = new ArrayList<>();
    }

    @Override
    public GameTrackModel getModel() {
        return model;
    }

    @Override
    public void setModel(GameTrackModel model) {
        this.model = model;
    }

    @Override
    public void setup(GameTrackModel model, List<GameTrackView> views) {
        this.setModel(model);
        model.setController(this);
        this.addViews(views);
    }

    @Override
    public void start() {
        for(GameTrackView v : views){
            v.display();
        }
    }

    @Override
    public void addView(GameTrackView view) {
        view.setController(this);
        this.views.add(view);
    }
    
    public void addViews(List<GameTrackView> views){
        for(GameTrackView v : views){
            this.addView(v);
        }
    }

    @Override
    public void removeView(GameTrackView view) {
        this.views.remove(view);
    }

    @Override
    public void setTrackGesture(String id, String userId, String gameId, String platformId, String progress, String playedHours) {
        GameTrack t = new GameTrackImpl(Integer.parseInt(id), new UserImpl(Integer.parseInt(userId)), new GameImpl(Integer.parseInt(gameId)), new PlatformImpl(Integer.parseInt(platformId)), progress, Double.parseDouble(playedHours));
        this.model.setTrack(t);
        
    }

    @Override
    public GameTrack getTrackGesture(String id) {
        return this.model.getTrack(Integer.parseInt(id));
    }

    @Override
    public void updateTrackGesture(String id, String userId, String gameId, String platformId, String progress, String playedHours) {
        GameTrack t = new GameTrackImpl(Integer.parseInt(id), new UserImpl(Integer.parseInt(userId)), new GameImpl(Integer.parseInt(gameId)), new PlatformImpl(Integer.parseInt(platformId)), progress, Double.parseDouble(playedHours));
        this.model.updateTrack(t);
    }

    @Override
    public void deleteTrackGesture(String id, String userId, String gameId, String platformId, String progress, String playedHours) {
        GameTrack t = new GameTrackImpl(Integer.parseInt(id), new UserImpl(Integer.parseInt(userId)), new GameImpl(Integer.parseInt(gameId)), new PlatformImpl(Integer.parseInt(platformId)), progress, Double.parseDouble(playedHours));
        this.model.deleteTrack(t);
    }

    @Override
    public List<GameTrack> listTracksGesture() {
        return this.model.listTracks();
    }

    @Override
    public void fireDataModelChanged() {
        for (GameTrackView v: this.views) {
            v.display();
        }
    }
    
    
    
}
