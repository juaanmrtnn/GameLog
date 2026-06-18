/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.entity;

import java.io.Serializable;

/**
 *
 * @author juanito
 */
public interface GameTrack extends Serializable {
    
    public int getId();

    public void setId(int id);
    
    public int getUserId();

    public void setUserId(int userId);

    public int getGameId();
    
    public void setGameId(int gameId);

    public int getPlatformId();
    
    public void setPlatformId(int platformId);
            
    public String getProgress();

    public void setProgress(String progress);

    public Double getPlayedHours();

    public void setPlayedHours(Double playedHours);
}
