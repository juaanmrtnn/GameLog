/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author juanito
 */
public class GameImpl implements Game {
    
    private int id;
    private String title;
    private String studio;
    private int launchYear;

    public GameImpl(int id, String title, String studio, int launchYear) {
        this.id = id;
        this.title = title;
        this.studio = studio;
        this.launchYear = launchYear;
    }
    
    public GameImpl(int id){
        this(id, null, null, 0);
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
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getStudio() {
        return studio;
    }

    @Override
    public void setStudio(String studio) {
        this.studio = studio;
    }

    @Override
    public int getLaunchYear() {
        return launchYear;
    }

    @Override
    public void setLaunchYear(int launchYear) {
        this.launchYear = launchYear;
    }
    
    @Override
    public String toString(){
        return this.title;
    }
}
