/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.GameModel;
import model.entity.Game;
import model.entity.GameImpl;
import view.game.GameView;

/**
 *
 * @author juanito
 */
public class GameControllerImpl implements GameController {
    
    private GameModel model;
    private List<GameView> views;

    public GameControllerImpl() {
        this.views = new ArrayList<>();
    }
    
    
    @Override
    public GameModel getModel() {
        return model;
    }

    @Override
    public void setModel(GameModel model) {
        this.model = model;
    }

    @Override
    public void setup(GameModel model, List<GameView> views) {
        this.setModel(model);
        model.setController(this);
        this.addViews(views);
    }

    @Override
    public void start() {
        for(GameView view : views){
            view.display();
        }
    }

    @Override
    public void addView(GameView view){
        view.setController(this); // 1. Le decimos a la vista quién es su controlador
        this.views.add(view);     // 2. Metemos la vista en nuestra lista interna
    }
    
    public void addViews(List<GameView> views) {
        for(GameView view : views){
            this.addView(view);   // 3. Reutilizamos el método de arriba para cada vista
        }
    }
    
    public void removeView(GameView view){
        this.views.remove(view);
    }

    @Override
    public void setGameGesture(String title, String studio, String launchYear) {
        Game game = new GameImpl(title, studio, Integer.parseInt(launchYear));
        this.model.setGame(game);
    }

    @Override
    public Game getGameGesture(String id) {
        Game game = this.model.getGame(Integer.parseInt(id));
        return game;
    }

    @Override
    public void updateGameGesture(String id, String title, String studio, String launchYear) {
        Game game = new GameImpl(Integer.parseInt(id), title, studio, Integer.parseInt(launchYear));
        this.model.updateGame(game);
    }

    @Override
    public void deleteGameGesture(String id, String title, String studio, String launchYear) {
        Game game = new GameImpl(Integer.parseInt(id)); 
        this.model.deleteGame(game);
    }

    @Override
    public List<Game> listGamesGesture() {
        return this.model.listGames();
    }
    
    @Override
    public void fireDataModelChanged() {
        for (GameView v: this.views) {
            v.display();
        }
    }
    
}
