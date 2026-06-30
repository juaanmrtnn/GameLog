/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gamelog;

import controller.GameController;
import controller.GameControllerImpl;
import controller.GameTrackController;
import controller.GameTrackControllerImpl;
import controller.PlatformController;
import controller.PlatformControllerImpl;
import controller.UserController;
import controller.UserControllerImpl;
import java.util.ArrayList;
import java.util.List;
import model.GameModel;
import model.GameModelImpl;
import model.GameTrackModel;
import model.GameTrackModelImpl;
import model.PlatformModel;
import model.PlatformModelImpl;
import model.UserModel;
import model.UserModelImpl;
import view.MainView;
import view.game.GameTableModel;
import view.game.GameView;
import view.game.GameViewImpl;
import view.gametrack.GameComboModel;
import view.gametrack.GameTrackTableModel;
import view.gametrack.GameTrackView;
import view.gametrack.GameTrackViewImpl;
import view.gametrack.PlatformComboModel;
import view.gametrack.UserComboModel;
import view.user.UserTableModel;
import view.user.UserView;
import view.user.UserViewImpl;

/**
 *
 * @author juanito
 */
public class GameLog {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // USERS
        UserModel userModel = new UserModelImpl();
        UserTableModel userTableModel = new UserTableModel();
        UserComboModel userComboModel = UserComboModel.create();
        
        UserView userView1 = new UserViewImpl();
        List<UserView> userViews = new ArrayList<UserView>();
        userViews.add(userView1);
        
        UserController userController = new UserControllerImpl();
        userController.setup(userModel, userTableModel, userComboModel, userViews);
        
        userController.start();
        
        // GAMES
        GameModel gameModel = new GameModelImpl();
        
        // models
        GameTableModel gameTableModel = new GameTableModel();
        GameComboModel gameComboModel = GameComboModel.create();
        
        GameView gameView1 = new GameViewImpl();
        List<GameView> gameViews = new ArrayList<>();
        gameViews.add(gameView1);
        
        GameController gameController = new GameControllerImpl();
        gameController.setup(gameModel, gameTableModel, gameComboModel, gameViews);
        gameController.start();
        
        
        // GAME TRACKS
        GameTrackModel gameTrackModel = new GameTrackModelImpl();
        GameTrackTableModel gameTrackTableModel = new GameTrackTableModel();
        
        GameTrackView gameTrackView1 = new GameTrackViewImpl();
        List<GameTrackView> gameTrackViews = new ArrayList<>();
        gameTrackViews.add(gameTrackView1);
        
        GameTrackController gameTrackController = new GameTrackControllerImpl();
        gameTrackController.setup(gameTrackModel, gameTrackTableModel, gameTrackViews);
        
        gameTrackController.start();
        
        // PLATFORMS
        PlatformModel platformModel = new PlatformModelImpl();
        
        PlatformController platformController = new PlatformControllerImpl();
        platformController.setup(platformModel);
        
        PlatformComboModel.create().setPlatforms(platformController.listPlatformsGesture());
        
        // MAIN VIEW
        MainView mainView1 = new MainView(userView1, gameView1, gameTrackView1);
        
        mainView1.display();
        
    }
    
}
