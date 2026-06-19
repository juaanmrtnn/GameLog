/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author juanito
 */
public class PlatformImpl implements Platform{
    
    private int id;
    private String platform;

    public PlatformImpl(int id, String platform) {
        this.id = id;
        this.platform = platform;
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
    public String getPlatform() {
        return platform;
    }

    @Override
    public void setPlatform(String platform) {
        this.platform = platform;
    }
    
    @Override
    public String toString(){
        return this.platform;
    }
    
}
