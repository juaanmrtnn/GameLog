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
    private Progress progress;
    private Double hours_played;

    public GameTrackImpl(String user_id, String game, Platform platform, Progress progress, Double hours_played) {
        this.user_id = user_id;
        this.game = game;
        this.platform = platform;
        this.progress = progress;
        this.hours_played = hours_played;
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
    public Progress getProgress() {
        return progress;
    }

    @Override
    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    @Override
    public Double getHoursPlayed() {
        return hours_played;
    }

    @Override
    public void setHoursPlayed(Double hours_played) {
        this.hours_played = hours_played;
    }

    @Override
    public String toString() {
        return "GameTrackImpl{" + "user_id=" + user_id + ", game=" + game + ", platform=" + platform + ", progress=" + progress + ", hours_played=" + hours_played + '}';
    }
    
    
}
