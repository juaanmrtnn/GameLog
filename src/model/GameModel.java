/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import controller.GameController;
import java.util.List;
import model.entity.Game;

/**
 *
 * @author juanito
 */
public interface GameModel {
    
    public GameController getController();
    
    public void setController(GameController controller);
    
    public void setGame(Game game);
    
    public Game getGame(int id);
    
    public void updateGame(Game game);
    
    public void deleteGame(Game game);
    
    public List<Game> listGames();
    
}
