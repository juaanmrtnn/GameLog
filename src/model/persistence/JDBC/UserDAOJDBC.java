/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.persistence.JDBC;

import model.entity.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.entity.UserImpl;
import model.persistence.UserDAO;

/**
 *
 * @author juanito
 */
public class UserDAOJDBC implements UserDAO {
    
    // CRUD operations to interact with the database
    
    @Override
    public void create(User user){
        String sql = "insert into users(user_id, username, email) values(?, ?, ?)";
        
        try {
            PreparedStatement pstmt = Persistence.createConnection().prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getEmail());
            pstmt.executeUpdate();
            
        } catch(SQLException e){
            System.out.println(e);
        } finally {
            Persistence.closeConnection();
        }
    }
    
    @Override
    public User read(int id){
        String sql = "select * from users where user_id = ?";
        User u = null;
        
        try {
            PreparedStatement pstmt = Persistence.createConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet res = pstmt.executeQuery();
            
            u = new UserImpl(res.getInt("user_id"), res.getString("username"), res.getString("email"));
            
        } catch(SQLException e){
            System.out.println(e);
        } finally {
            Persistence.closeConnection();
        }
        
        return u;
    }
    
    @Override
    public void update(User user){
        String sql = "update users set username = ?, email = ? where user_id = ?";
        
        try {
            PreparedStatement pstmt = Persistence.createConnection().prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setInt(3, user.getId());
            pstmt.executeUpdate();
            
        } catch(SQLException e){
            System.out.println(e);    
        } finally {
            Persistence.closeConnection();
        }
    }
    
    @Override
    public void delete(User user){
        String sql = "delete from users where user_id = ?";
        
        try {
            PreparedStatement pstmt = Persistence.createConnection().prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            pstmt.executeUpdate();
            
        } catch(SQLException e){
            System.out.println(e);
        } finally {
            Persistence.closeConnection();
        }
    }
    
    @Override
    public List<User> list(){
        List<User> users = new ArrayList<>();
        String sql = "select * from users";
        
        try {
            Statement stmt = Persistence.createConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            
            while(res.next()){
                users.add(new UserImpl(res.getInt("user_id"), res.getString("username"), res.getString("email")));
            }
            res.close();
            
        } catch(SQLException e){
            System.out.println(e);
        } finally{
            Persistence.closeConnection();
        }
        
        return users;
    }
    
}
