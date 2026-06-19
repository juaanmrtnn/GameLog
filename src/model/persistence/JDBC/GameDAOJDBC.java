/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.persistence.JDBC;

import java.util.ArrayList;
import java.util.List;
import model.entity.Game;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entity.GameImpl;

/**
 *
 * @author juanito
 */
public class GameDAOJDBC {
    
    public List<Game> list(){
        List<Game> games = new ArrayList<>();
        String sql = "SELECT * FROM games";
        
        try {
            Statement stmt = Persistence.createConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            
            while(res.next()){
                games.add(new GameImpl(res.getInt("id"), res.getString("title"), res.getString("studio"), res.getInt("launch_year")));
            }
            res.close();
            
        } catch(SQLException e){
            System.out.println(e);
        } finally{
            Persistence.closeConnection();
        }
        
        return games;
    }
}
