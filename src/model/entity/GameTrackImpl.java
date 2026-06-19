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
    private int userId;
    private int gameId;
    private int platformId;
    private String progress;
    private Double playedHours;

    public GameTrackImpl(int id, int userId, int gameId, int platformId, String progress, Double playedHours) {
        this.id = id;
        this.userId = userId;
        this.gameId = gameId;
        this.platformId = platformId;
        this.progress = progress;
        this.playedHours = playedHours;
    }
    
    public GameTrackImpl(int id){
        this(id,0,0,0,null,0.0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int getGameId() {
        return gameId;
    }

    @Override
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Override
    public int getPlatformId() {
        return platformId;
    }

    @Override
    public void setPlatformId(int platformId) {
        this.platformId = platformId;
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
