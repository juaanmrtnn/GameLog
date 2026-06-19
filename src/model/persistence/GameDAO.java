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
    
    public List<Game> list();
    
}
