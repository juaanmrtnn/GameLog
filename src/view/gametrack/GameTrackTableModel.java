/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.gametrack;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import model.entity.GameTrack;

/**
 *
 * @author juanito
 */
public class GameTrackTableModel {
    
    private List<GameTrack> tracks = new ArrayList<GameTrack>();
    private List<TableModelListener> tableListeners = new ArrayList<TableModelListener>();

    public List<GameTrack> getTracks() {
        return tracks;
    }

    public void setTracks(List<GameTrack> tracks) {
        this.tracks = tracks;
        fireContentsChanged();
    }

    protected void fireContentsChanged() {
        fireContentsChangedTableModel();
    }
    //--------------- MÉTODOS PROPIOS DE TableModel -------------------------

    public GameTrack getRow(int indexRow) {
        return tracks.get(indexRow);
    }

    public int getRowCount() {
        return tracks.size();
    }

    public int getColumnCount() {
        return 5; //ya que tendremos tres valores a mostrar por cliente
    }

    public String getColumnName(int columnIndex) {
        String name = null;
        switch (columnIndex) {
            case 0:
                name = "User";
                break;
            case 1:
                name = "Game";
                break;
            case 2:
                name = "Platform";
                break;
            case 3:
                name = "Played Hours";
                break;
            case 4:
                name = "Platform";
                break;
        }
        return name;
    }

    public Class<?> getColumnClass(int columnIndex) {
        Class c = null;
        switch (columnIndex) {
            case 0:
                c = String.class;
                break;
            case 1:
                c = String.class;
                break;
            case 2:
                c = String.class;
                break;
            case 3:
                c = Double.class;
                break;
            case 4:
                c = String.class;
                break;
        }
        return c;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //No permito editar celdas
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        GameTrack track = tracks.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = track.getUserId();
                break;
            case 1:
                value = factura.getCliente().getDNI();
                break;
            case 2:
                value = factura.getImporte();
                break;
        }
        return value;

    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addTableModelListener(TableModelListener l) {
        tableListeners.add(l);
    }

    public void removeTableModelListener(TableModelListener l) {
        tableListeners.remove(l);
    }

    protected void fireContentsChangedTableModel() {
        
        TableModelEvent event = new TableModelEvent(this, 0, this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        for (TableModelListener listener : tableListeners) {
            listener.tableChanged(event);
        }
    }
    
}
