/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.game;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import model.entity.Game;

/**
 *
 * @author juanito
 */
public class GameTableModel implements TableModel {
    
    private List<Game> games = new ArrayList<Game>();
    private List<TableModelListener> tableListeners = new ArrayList<TableModelListener>();

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
        fireContentsChanged();
    }

    protected void fireContentsChanged() {
        fireContentsChangedTableModel();
    }

    // TABLEMODEL METHODS
    
    @Override
    public int getRowCount() {
        return games.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String name = null;
        switch (columnIndex) {
            case 0:
                name = "Title";
                break;
            case 1:
                name = "Studio";
                break;
            case 2:
                name = "Launch Year";
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class c = null;
        switch (columnIndex) {
            case 0:
                c= String.class;
                break;
            case 1:
                c = String.class;
                break;
            case 2:
                c = Integer.class;
        }
        return c;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Game game = games.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = game.getTitle();
                break;
            case 1:
                value = game.getStudio();
                break;
            case 2:
                value = game.getLaunchYear();
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
