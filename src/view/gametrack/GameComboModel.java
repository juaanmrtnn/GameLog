/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.gametrack;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import model.entity.Game;

/**
 *
 * @author juanito
 */
public class GameComboModel implements ComboBoxModel {
    
    private List<Game> games = new ArrayList<Game>();
    private List<ListDataListener> dataListeners = new ArrayList<ListDataListener>();
    private Game gameSelected = null;

    // singleton
    private static GameComboModel model=null;

    private GameComboModel(){}

    public static GameComboModel create(){
        if(model==null)
            model=new GameComboModel();
        return model;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
        this.gameSelected = null;
        fireContentsChanged();
    }

    protected void fireContentsChanged() {
        fireContentsChangedListData();
    }
    
    // comboBox methods

    public void setSelectedItem(Object anItem) {
        if (anItem != null) {
            gameSelected = (Game) anItem;
            fireContentsChangedListData();
        }
    }

    public Object getSelectedItem() {
        return gameSelected;
    }

    public int getSize() {
        return games.size();
    }

    public Object getElementAt(int index) {
        return games.get(index);
    }

    public void addListDataListener(ListDataListener l) {
        dataListeners.add(l);
    }

    public void removeListDataListener(ListDataListener l) {
        dataListeners.remove(l);
    }

    protected void fireContentsChangedListData() {
        ListDataEvent e = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, games.size());
        
        ArrayList<ListDataListener> copyListeners = new ArrayList<>(dataListeners);
        for (ListDataListener l : copyListeners) {
            l.contentsChanged(e);
        }
    }
    
}
