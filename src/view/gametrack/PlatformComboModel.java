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
import model.entity.Platform;

/**
 *
 * @author juanito
 */
public class PlatformComboModel implements ComboBoxModel {
    
    private List<Platform> platforms = new ArrayList<Platform>();
    private List<ListDataListener> dataListeners = new ArrayList<ListDataListener>();
    private Platform platformSelected = null;

    // singleton
    private static PlatformComboModel model=null;

    private PlatformComboModel(){}

    public static PlatformComboModel create(){
        if(model==null)
            model=new PlatformComboModel();
        return model;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
        fireContentsChanged();
    }

    protected void fireContentsChanged() {
        fireContentsChangedListData();
    }
    
    // comboBox methods

    public void setSelectedItem(Object anItem) {
        if (anItem != null) {
            platformSelected = (Platform) anItem;
            fireContentsChangedListData();
        }
    }

    public Object getSelectedItem() {
        return platformSelected;
    }

    public int getSize() {
        return platforms.size();
    }

    public Object getElementAt(int index) {
        return platforms.get(index);
    }

    public void addListDataListener(ListDataListener l) {
        dataListeners.add(l);
    }

    public void removeListDataListener(ListDataListener l) {
        dataListeners.remove(l);
    }

    protected void fireContentsChangedListData() {
        ListDataEvent e = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, platforms.size());
        
        ArrayList<ListDataListener> copyListeners = new ArrayList<>(dataListeners);
        for (ListDataListener l : copyListeners) {
            l.contentsChanged(e);
        }
    }
    
}
