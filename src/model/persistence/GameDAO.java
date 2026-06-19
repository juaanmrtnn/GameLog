/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.persistence;

import java.util.List;
import java.util.ArrayList;
import model.entity.Game;

/**
 *
 * @author juanito
 */
public interface GameDAO {
    
    public void create(Game game);
    
    public Game read(int id);
    
    public void update(Game game);
    
    public void delete(Game game);
    
    public List<Game> list();
    
}
