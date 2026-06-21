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
import model.entity.User;

/**
 *
 * @author juanito
 */
public class UserComboModel implements ComboBoxModel {
    
    private List<User> users = new ArrayList<User>();
    private List<ListDataListener> dataListeners = new ArrayList<ListDataListener>();
    private User userSelected = null;

    // singleton
    private static UserComboModel model=null;

    private UserComboModel(){}

    public static UserComboModel create(){
        if(model==null)
            model=new UserComboModel();
        return model;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        this.userSelected = null;
        fireContentsChanged();
    }

    protected void fireContentsChanged() {
        fireContentsChangedListData();
    }
    
    // comboBox methods

    public void setSelectedItem(Object anItem) {
        if (anItem != null) {
            userSelected = (User) anItem;
            fireContentsChangedListData();
        }
    }

    public Object getSelectedItem() {
        return userSelected;
    }

    public int getSize() {
        return users.size();
    }

    public Object getElementAt(int index) {
        return users.get(index);
    }

    public void addListDataListener(ListDataListener l) {
        dataListeners.add(l);
    }

    public void removeListDataListener(ListDataListener l) {
        dataListeners.remove(l);
    }

    protected void fireContentsChangedListData() {
        ListDataEvent e = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, users.size());
        
        ArrayList<ListDataListener> copyListeners = new ArrayList<>(dataListeners);
        for (ListDataListener l : copyListeners) {
            l.contentsChanged(e);
        }
    }
}
