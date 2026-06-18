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
    private int user_id;
    private int game_id;
    private int platform_id;
    private String progress;
    private Double played_hours;

    public GameTrackImpl(int id, int user_id, int game_id, int platform_id, String progress, Double played_hours) {
        this.id = id;
        this.user_id = user_id;
        this.game_id = game_id;
        this.platform_id = platform_id;
        this.progress = progress;
        this.played_hours = played_hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public int getUserId() {
        return user_id;
    }

    @Override
    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public int getGameId() {
        return game_id;
    }

    @Override
    public void setGameId(int game_id) {
        this.game_id = game_id;
    }

    @Override
    public int getPlatformId() {
        return platform_id;
    }

    @Override
    public void setPlatformId(int platform_id) {
        this.platform_id = platform_id;
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
