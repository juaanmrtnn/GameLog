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
import model.persistence.GameDAO;

/**
 *
 * @author juanito
 */
public class GameDAOJDBC implements GameDAO {
    
    // CRUD operations to interact with the database
    
    @Override
    public void create(Game game){
        String sql = "insert into games(id, title, studio, launch_year) values(?, ?, ?, ?)";
        
        try {
            PreparedStatement pstmt = Persistence.createConnection().prepareStatement(sql);
            pstmt.setInt(1, game.getId());
            pstmt.setString(2, game.getTitle());
            pstmt.setString(3, game.getStudio());
            pstmt.setInt(4, game.getLaunchYear());
            pstmt.executeUpdate();
            
        } catch(SQLException e){
            System.out.println(e);
        } finally {
            Persistence.closeConnection();
        }
    }
    
    @Override
    public Game read(int id){
        String sql = "select * from games where id = ?";
        Game g = null;
        
        try {
            PreparedStatement pstmt = Persistence.createConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet res = pstmt.executeQuery();
            
            g = new GameImpl(res.getInt("id"), res.getString("title"), res.getString("studio"), res.getInt("launch_year"));
            
        } catch(SQLException e){
            System.out.println(e);
        } finally {
            Persistence.closeConnection();
        }
        
        return g;
    }
    
    @Override
    public void update(Game game){
        String sql = "update games set title = ?, studio = ?, launch_year = ? where id = ?";
        
        try {
            PreparedStatement pstmt = Persistence.createConnection().prepareStatement(sql);
            pstmt.setString(1, game.getTitle());
            pstmt.setString(2, game.getStudio());
            pstmt.setInt(3, game.getLaunchYear());
            pstmt.setInt(4, game.getId());
            pstmt.executeUpdate();
            
        } catch(SQLException e){
            System.out.println(e);    
        } finally {
            Persistence.closeConnection();
        }
    }
    
    @Override
    public void delete(Game game){
        String sql = "delete  from games where id = ?";
        
        try {
            PreparedStatement pstmt = Persistence.createConnection().prepareStatement(sql);
            pstmt.setInt(1, game.getId());
            pstmt.executeUpdate();
            
        } catch(SQLException e){
            System.out.println(e);
        } finally {
            Persistence.closeConnection();
        }
    }
    
    @Override
    public List<Game> list(){
        List<Game> games = new ArrayList<>();
        String sql = "select * from games";
        
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
