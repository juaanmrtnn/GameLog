/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.entity;

import java.io.Serializable;

/**
 *
 * @author juanito
 */
public interface Game extends Serializable {
    
    public int getId();

    public void setId(int id);

    public String getTitle();

    public void setTitle(String title);

    public String getStudio();

    public void setStudio(String studio);

    public int getLaunchYear();

    public void setLaunchYear(int launchYear);

}
