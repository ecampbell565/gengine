package com.gyroscopegames.gengine.engine;

import android.content.Context;
import android.content.res.Resources;

import com.gyroscopegames.gengine.GameObjects.GameObject;
import com.gyroscopegames.gengine.engine.database.Database;
import com.gyroscopegames.gengine.GameObjects.implementation.Player;
import com.gyroscopegames.gengine.engine.logic.LogicUpdater;
import com.gyroscopegames.gengine.engine.logic.Scene;
import com.gyroscopegames.gengine.engine.logic.StateController;
import com.gyroscopegames.gengine.engine.logic.UIListener;
import com.gyroscopegames.gengine.engine.ui.Graphics;
import com.gyroscopegames.gengine.engine.ui.Input;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * The class that implements this interface should also extend the Activity class,
 * and acts as the entry point for this engine.  The abstract methods defined in this interface
 * should provide guidelines as to what should be initialized in the implementing
 * class.
 * Created 12/30/2015 by Eric Campbell
 */
public interface Game {

    /**
     * Provides access to the main Database handling object of your applicatoin
     * @return          A database object
     */
    public Database getDatabaseObject();

    /**
     * Provides access to the scene that is currently being rendered and used
     * @return          A Scene object
     */
    public Scene getCurrentScene();

    /**
     * TODO: obsoleted, instead use MultiTouchHandler
     * @return
     */
    public List<UIListener> getEventListeners();

    /**
     * TODO: obsoleted, instead use MultiTouchHandler
     * @param listener
     */
    public void addUIListener(UIListener listener);

    /**
     * Should return the UUID of the client of the instance of the application, which should be stored
     * locally on the client's device, and retrieved on initialization of the game
     * @return          UUID of client of application
     */
    public Player.PlayerUUID getUserId();

    /**
     * Returns UUID of opponent client, which should be initialized along with the game
     * @return          UUID of opponent client, in case of PvP (TODO: change to list for larger multiplayer games)
     */
    public Player.PlayerUUID getOpponentId();

    /**
     * Provides access to the StateHandler
     * TODO: disambiguate
     * @return          LogicUpdater handler for game, should be initialized BEFORE starting game thread
     */
    public StateController getStateController();

    /**
     * TODO: remove
     * @return
     */
    public Context getContext();

    /**
     * TODO: investigate usages and provide sufficient implementation
     * @param newScene
     */
    public void changeScene(Scene newScene);

    /**
     * Provides access for the Graphics handler object for the application
     * @return          Graphics object handler
     */
    public Graphics getGraphics();

    /**
     * Provides access to the Logic Updater object that acts as a logic handler
     * for this application
     * @return          LogicUpdater object logic handler
     */
    public LogicUpdater getLogicUpdater();

    /**
     * Provides access to touch events and input received from the current view
     * @return          Input object
     */
    public Input getInput();

    /**
     * @return          Returns the executor service that is used to execute the
     *                  variety of tasks used in the application
     */
    public ExecutorService getTaskExecutor();

    /**
     * @return          Returns the scene that the application will start with as a
     *                  Scene object
     */
    public Scene getInitScene();

    /**
     * @return          Returns the resources of the application as a Resource object
     */
    public Resources getRes();

    /**
     * @return          Returns a list of gameObjects and their state
     */
    public HashMap<GameObject.ObjectType, GameObject> getGameObjects();

    /**
     * Appends an object of a subclass of GameObjects to the
     * current list of gameObjects
     *
     * @param type      The type of the object added, be sure to add the type to the enum in
     *                  Object Type
     * @param object    The object being added
     */
    public void addGameObject(GameObject.ObjectType type, GameObject object);
}
