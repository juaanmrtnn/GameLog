/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.util.List;
import model.GameModel;
import model.entity.Game;
import view.game.GameTableModel;
import view.game.GameView;
import view.gametrack.GameComboModel;

/**
 *
 * @author juanito
 */
public interface GameController {
    
    public GameModel getModel();
    
    public void setModel(GameModel model);
    
    // bind model to view
    public void setup(GameModel model, GameTableModel tableModel, GameComboModel comboModel, List<GameView> views);
    
    public void start();
    
    public void addView(GameView view);
    
    public void removeView(GameView view);
    
    public void setGameGesture(String title, String studio, String launchYear);
    
    public Game getGameGesture(String id);
    
    public void updateGameGesture(String id, String title, String studio, String launchYear);
    
    public void deleteGameGesture(String id, String title, String studio, String launchYear);
    
    public List<Game> listGamesGesture();
    
    public void fireDataModelChanged();
    
}
