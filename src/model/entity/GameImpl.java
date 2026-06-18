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
    
    private String id;
    private String title;
    private String studio;
    private int launch_year;

    public GameImpl(String id, String title, String studio, int launch_year) {
        this.id = id;
        this.title = title;
        this.studio = studio;
        this.launch_year = launch_year;
    }
    
    public GameImpl(String id){
        this(id, null, null, 0);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
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
    public int getLaunch_year() {
        return launch_year;
    }

    @Override
    public void setLaunch_year(int launch_year) {
        this.launch_year = launch_year;
    }
    
    @Override
    public String toString(){
        return this.title;
    }
}
