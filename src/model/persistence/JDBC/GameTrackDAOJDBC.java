/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.persistence.JDBC;

import model.entity.GameTrack;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.entity.Game;
import model.entity.GameImpl;
import model.entity.GameTrackImpl;
import model.entity.Platform;
import model.entity.PlatformImpl;
import model.entity.User;
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
        String sql = "update game_track set user_id = ?, game_id = ?, platform_id = ?, progress = ?, played_hours = ? where id = ?";
        
        try {
            PreparedStatement pstmt = Persistence.createConnection().prepareStatement(sql);
            pstmt.setInt(1, track.getUser().getId());
            pstmt.setInt(2, track.getGame().getId());
            pstmt.setInt(3, track.getPlatform().getId());
            pstmt.setString(4, track.getProgress());
            pstmt.setDouble(5, track.getPlayedHours());
            pstmt.setInt(6, track.getId());
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
        String sql = "SELECT t.id, t.user_id, t.game_id, t.platform_id, t.progress, t.played_hours, " +
                     "u.username, u.email, " +
                     "g.title, g.studio, g.launch_year, " +
                     "p.platform " +
                     "FROM game_track t " +
                     "INNER JOIN users u ON t.user_id = u.user_id " +
                     "INNER JOIN games g ON t.game_id = g.id " +
                     "INNER JOIN platforms p ON t.platform_id = p.id";
        
        try {
            Statement stmt = Persistence.createConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            
            while(res.next()){
                User user = new UserImpl(res.getInt("user_id"), res.getString("username"), res.getString("email"));
                Game game = new GameImpl(res.getInt("game_id"), res.getString("title"), res.getString("studio"), res.getInt("launch_year"));
                Platform platform = new PlatformImpl(res.getInt("platform_id"), res.getString("platform"));
                
                tracks.add(new GameTrackImpl(res.getInt("id"), user, game, platform, res.getString("progress"), res.getDouble("played_hours")));
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
