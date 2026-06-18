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
    
    public String getId();

    public void setId(String id);

    public String getTittle();

    public void setTittle(String tittle);

    public String getStudio();

    public void setStudio(String studio);

    public int getLaunch_year();

    public void setLaunch_year(int launch_year);

}
