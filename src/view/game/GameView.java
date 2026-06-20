/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view.game;

import controller.GameController;

/**
 *
 * @author juanito
 */
public interface GameView {
    
    public GameController getController();
    
    public void setController(GameController controller);
    
    public void dataModelChanged();
    
    public void display();
    
}
