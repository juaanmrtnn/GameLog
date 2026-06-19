/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.GameController;
import java.util.List;
import model.entity.Game;
import model.persistence.GameDAO;
import model.persistence.JDBC.GameDAOJDBC;
import view.game.GameView;

/**
 *
 * @author juanito
 */
public class GameModelImpl implements GameModel {
    
    private GameController controller;

    @Override
    public GameController getController() {
        return controller;
    }

    @Override
    public void setController(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void setGame(Game game) {
        GameDAO dao = new GameDAOJDBC();
        dao.create(game);
        this.controller.fireDataModelChanged();
    }

    @Override
    public Game getGame(int id) {
        GameDAO dao = new GameDAOJDBC();
        Game game = dao.read(id);
        return game;
    }

    @Override
    public void updateGame(Game game) {
        GameDAO dao = new GameDAOJDBC();
        dao.update(game);
        this.controller.fireDataModelChanged();
    }

    @Override
    public void deleteGame(Game game) {
        GameDAO dao = new GameDAOJDBC();
        dao.delete(game);
        this.controller.fireDataModelChanged();
    }

    @Override
    public List<Game> listGames() {
        GameDAO dao = new GameDAOJDBC();
        return dao.list();
    }
    
}
