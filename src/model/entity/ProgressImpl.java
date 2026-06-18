/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author juanito
 */
public class ProgressImpl implements Progress {
    
    private String progress;

    public ProgressImpl(String progress) {
        this.progress = progress;
    }

    @Override
    public String getProgress() {
        return progress;
    }

    @Override
    public void setProgress(String progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return this.progress;
    }
    
    
    
}
