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
    
    public String getUserId();

    public void setUserId(String user_id);

    public String getGame();

    public void setGame(String game);

    public Platform getPlatform();

    public void setPlatform(Platform platform);
            
    public Progress getProgress();

    public void setProgress(Progress progress);

    public Double getPlayedHours();

    public void setPlayedHours(Double played_hours);
}
