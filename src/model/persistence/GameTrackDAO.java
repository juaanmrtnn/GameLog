/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.persistence;

import java.util.List;
import model.entity.GameTrack;

/**
 *
 * @author juanito
 */
public interface GameTrackDAO {
    
    public void create(GameTrack track);
    
    public GameTrack read(int id);
    
    public void update(GameTrack track);
    
    public void delete(GameTrack track);
    
    public List<GameTrack> list();
}
