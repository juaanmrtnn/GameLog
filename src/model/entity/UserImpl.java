/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author juanito
 */
public class UserImpl implements User {
    
    private int id;
    private String username;
    private String email;

    public UserImpl(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        
    }
    
    public UserImpl(int id){
        this(id, null, null);
    }

    // constructor overloading to handle search by username operation
    public UserImpl(String username){
        this(0, username, null);
    }
    
    // constructor overloading to handle auto-increment ids
    public UserImpl(String username, String email){
        this.id = 0;
        this.username = username;
        this.email = email;
    }
    
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString(){
        return this.username;
    }
    
}
