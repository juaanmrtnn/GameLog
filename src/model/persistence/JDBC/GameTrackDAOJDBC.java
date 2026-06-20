/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.persistence.JDBC;

import model.entity.GameTrack;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.entity.GameImpl;
import model.entity.GameTrackImpl;
import model.entity.PlatformImpl;
import model.entity.UserImpl;
import model.persistence.GameTrackDAO;
/**
 *
 * @author juanito
 */
public class GameTrackDAOJDBC implements GameTrackDAO {
    
    // CRUD operations to interact with the database
    
    @Override
    public void create(GameTrack track){
        String sql = "insert into game_track(user_id, game_id, platform_id, progress, played_hours) values(?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement pstmt = Persistence.createConnection().prepareStatement(sql);
            pstmt.setInt(1, track.getUser().getId());
            pstmt.setInt(2, track.getGame().getId());
            pstmt.setInt(3, track.getPlatform().getId());
            pstmt.setString(4, track.getProgress());
            pstmt.setDouble(5, track.getPlayedHours());
            pstmt.executeUpdate();
            
        } catch(SQLException e){
            System.out.println(e);
        } finally {
            Persistence.closeConnection();
        }
    }
    
    @Override
    public GameTrack read(int id){
        String sql = "select * from game_track where id = ?";
        GameTrack t = null;
        
        try {
            PreparedStatement pstmt = Persistence.createConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet res = pstmt.executeQuery();
            
            t = new GameTrackImpl(res.getInt("id"), new UserImpl(res.getInt("user_id")), new GameImpl(res.getInt("game_id")), new PlatformImpl(res.getInt("platform_id")), res.getString("progress"), res.getDouble("played_hours"));
            
        } catch(SQLException e){
            System.out.println(e);
        } finally {
            Persistence.closeConnection();
        }
        
        return t;
    }
    
    @Override
    public void update(GameTrack track){
        String sql = "update game_track set progress = ?, played_hours = ? where id = ?";
        
        try {
            PreparedStatement pstmt = Persistence.createConnection().prepareStatement(sql);
            pstmt.setString(1, track.getProgress());
            pstmt.setDouble(2, track.getPlayedHours());
            pstmt.setInt(3, track.getId());
            pstmt.executeUpdate();
            
        } catch(SQLException e){
            System.out.println(e);    
        } finally {
            Persistence.closeConnection();
        }
    }
    
    @Override
    public void delete(GameTrack track){
        String sql = "delete from game_track where id = ?";
        
        try {
            PreparedStatement pstmt = Persistence.createConnection().prepareStatement(sql);
            pstmt.setInt(1, track.getId());
            pstmt.executeUpdate();
            
        } catch(SQLException e){
            System.out.println(e);
        } finally {
            Persistence.closeConnection();
        }
    }
    
    @Override
    public List<GameTrack> list(){
        List<GameTrack> tracks = new ArrayList<>();
        String sql = "select * from game_track";
        
        try {
            Statement stmt = Persistence.createConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            
            while(res.next()){
                tracks.add(new GameTrackImpl(res.getInt("id"), new UserImpl(res.getInt("user_id")), new GameImpl(res.getInt("game_id")), new PlatformImpl(res.getInt("platform_id")), res.getString("progress"), res.getDouble("played_hours")));
            }
            res.close();
            
        } catch(SQLException e){
            System.out.println(e);
        } finally{
            Persistence.closeConnection();
        }
        
        return tracks;
    }
    
}
