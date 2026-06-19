/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.persistence.JDBC;

import model.entity.Platform;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.entity.PlatformImpl;
import model.persistence.PlatformDAO;

/**
 *
 * @author juanito
 */
public class PlatformDAOJDBC implements PlatformDAO {
    // CRUD operations to interact with the database
    
    @Override
    public Platform read(int id){
        String sql = "select * from platforms where id = ?";
        Platform p = null;
        
        try {
            PreparedStatement pstmt = Persistence.createConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet res = pstmt.executeQuery();
            
            p = new PlatformImpl(res.getInt("id"), res.getString("platform"));
            
        } catch(SQLException e){
            System.out.println(e);
        } finally {
            Persistence.closeConnection();
        }
        
        return p;
    }
    
    @Override
    public List<Platform> list(){
        List<Platform> platforms = new ArrayList<>();
        String sql = "select * from platforms";
        
        try {
            Statement stmt = Persistence.createConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            
            while(res.next()){
                platforms.add(new PlatformImpl(res.getInt("id"), res.getString("platform")));
            }
            res.close();
            
        } catch(SQLException e){
            System.out.println(e);
        } finally{
            Persistence.closeConnection();
        }
        
        return platforms;
    }
    
}
