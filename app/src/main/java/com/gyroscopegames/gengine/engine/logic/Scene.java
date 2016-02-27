package com.gyroscopegames.gengine.engine.logic;

import com.gyroscopegames.gengine.GameObjects.GameObject;
import com.gyroscopegames.gengine.engine.Game;
import com.gyroscopegames.gengine.implementation.SquaredRenderView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Eric R. Campbell on 12/30/2015.
 * Subclass and implement this class for custom graphics
 */
public abstract class Scene {

    /**
     * Use this HashMap to list game objects, paired with their base type which should
     * be derived from the enum in GameObject, ObjectType
     */
    protected HashMap<GameObject.ObjectType, GameObject> gameObjects = new HashMap<>();

    /**
     * The game object used for coupling between classes
     */
    protected Game game;

    /**
     * Main constructor for the Scene class
     */
    public Scene(Game game) {
        this.game = game;
    }

    /**
     * Implement this method to prove logic specific to an individual level
     * @param deltaTime     Provides the time passed between game cycles
     */
    public abstract void update(float deltaTime);

    /**
     * Implement this method to make drawing calls to a Graphics object,
     * preferably retrieved via game.getGraphics()
     * @param deltaTime     Provides the time passed between game cycles
     * @param renderView    So far obsolete parameter used for locking mechanisms
     *                      on the SquaredRenderView class
     * @param lock          Used for locking mechanisms on SquaredRenderView class,
     *                      possibly not necessary
     */
    public void draw(float deltaTime, SquaredRenderView renderView, Object lock) {
        renderView.sceneFinished.set(true);
        synchronized (SquaredRenderView.lock) {
            lock.notifyAll();
        }
    } //An interface needs to be created to abstract this coupling

    /**
     * Clean up for instantiated variables when the Scene object is detroyed
     */
    public abstract void onDestroy();

    /**
     * Initialize variables for the Scene class, this shouldn't be needed
     */
    public abstract void onCreate();

    /**
     * Debug
     */
    public abstract void onInvalidate(); //DEBUG purposes primarily

}
