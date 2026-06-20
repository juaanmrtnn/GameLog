/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author juanito
 */
public class GameTrackImpl implements GameTrack {
    private int id;
    private User user;
    private Game game;
    private Platform platform;
    private String progress;
    private Double playedHours;

    public GameTrackImpl(int id, User user, Game game, Platform platform, String progress, Double playedHours) {
        this.id = id;
        this.user = user;
        this.game = game;
        this.platform = platform;
        this.progress = progress;
        this.playedHours = playedHours;
    }
    
    public GameTrackImpl(int id){
        this(id,null,null,null,null,0.0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public Platform getPlatform() {
        return platform;
    }

    @Override
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @Override
    public String getProgress() {
        return progress;
    }

    @Override
    public void setProgress(String progress) {
        this.progress = progress;
    }

    @Override
    public Double getPlayedHours() {
        return playedHours;
    }

    @Override
    public void setPlayedHours(Double playedHours) {
        this.playedHours = playedHours;
    }

    
    
}
