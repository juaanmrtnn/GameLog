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
    
    public User getUser();

    public void setUser(User user);

    public Game getGame();
    
    public void setGame(Game game);

    public Platform getPlatform();
    
    public void setPlatform(Platform platform);
            
    public String getProgress();

    public void setProgress(String progress);

    public Double getPlayedHours();

    public void setPlayedHours(Double playedHours);
}
