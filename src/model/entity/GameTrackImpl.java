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
    private String user_id;
    private String game;
    private Platform platform;
    private String progress;
    private Double played_hours;

    public GameTrackImpl(String user_id, String game, Platform platform, String progress, Double played_hours) {
        this.user_id = user_id;
        this.game = game;
        this.platform = platform;
        this.progress = progress;
        this.played_hours = played_hours;
    }

    @Override
    public String getUserId() {
        return user_id;
    }

    @Override
    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String getGame() {
        return game;
    }

    @Override
    public void setGame(String game) {
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
        return played_hours;
    }

    @Override
    public void setPlayedHours(Double played_hours) {
        this.played_hours = played_hours;
    }

    
    
}
