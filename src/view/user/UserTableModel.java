/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.user;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import model.entity.User;

/**
 *
 * @author juanito
 */
public class UserTableModel implements TableModel {
    
    private List<User> users = new ArrayList<User>();
    private List<TableModelListener> tableListeners = new ArrayList<TableModelListener>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        fireContentsChanged();
    }

    protected void fireContentsChanged() {
        fireContentsChangedTableModel();
    }

    // TABLEMODEL METHODS
    
    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String name = null;
        switch (columnIndex) {
            case 0:
                name = "Username";
                break;
            case 1:
                name = "Email";
                break;
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class c = null;
        switch (columnIndex) {
            case 0:
                c=String.class;
                break;
            case 1:
                c = String.class;
                break;
        }
        return c;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = users.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = user.getUsername();
                break;
            case 1:
                value = user.getEmail();
                break;
        }
        return value;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        tableListeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        tableListeners.remove(l);
    }
    
    protected void fireContentsChangedTableModel() {
        TableModelEvent event = new TableModelEvent(this, 0, this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        
        ArrayList<TableModelListener> copyListeners = new ArrayList<>(tableListeners);
        for (TableModelListener listener : copyListeners) {
            listener.tableChanged(event);
        }
    }
    
}
