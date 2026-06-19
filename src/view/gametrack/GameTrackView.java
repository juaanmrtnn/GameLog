/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view.gametrack;

import controller.GameTrackController;

/**
 *
 * @author juanito
 */
public interface GameTrackView {
    
    public GameTrackController getController();
    
    public void setController(GameTrackController controller);
    
    public void display();
    
}
