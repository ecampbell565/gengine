package com.gyroscopegames.gengine.Scenes;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.gyroscopegames.gengine.GameObjects.implementation.ExampleObject;
import com.gyroscopegames.gengine.engine.engine.Game;
import com.gyroscopegames.gengine.engine.logic.Scene;
import com.gyroscopegames.gengine.engine.ui.Graphics;
import com.gyroscopegames.gengine.engine.view.SquaredRenderView;

/**
 * Example Scene class
 * Provides examples for how one should implement the methods
 * provided by the Scene.java
 * Created by Eric R. Campbell on 1/2/2016.
 */
public class ExampleScene extends Scene {

    public static final String TAG = "EXAMPLE_SCENE";
    private ExampleObject foo;

    /**
     * Constructor for a Sample Scene class, should call the super for Scene passing in the
     * game parameter
     * @param game      The game parameter used for abstraction
     */
    public ExampleScene(Game game) {
        super(game);
        foo = new ExampleObject();
        Log.i(TAG, "Example scene successfully initialized");
    }

    /**
     * Call logic methods interacting with GameObject states in this method,
     * logic used in this method should be specific to the level or scene
     * @param deltaTime     Provides the time passed between game cycles
     */
    @Override
    public void update(float deltaTime) {
        Log.i(TAG, "update method called, sysTime: " + System.currentTimeMillis());
    }

    /**
     * Object calls on the Graphics class here, MUST include super.draw in your
     * method implementation
     * @param deltaTime     Provides the time passed between game cycles
     * @param renderView    So far obsolete parameter used for locking mechanisms
     *                      on the SquaredRenderView class
     * @param lock          Used for locking mechanisms on SquaredRenderView class,
     */
    @Override
    public void draw(float deltaTime, SquaredRenderView renderView, Object lock) {
        Log.i(TAG, "draw method called, sysTime: " + System.currentTimeMillis());
        Graphics g = game.getGraphics();
        Paint p = new Paint();
        p.setColor(Color.YELLOW);
        g.drawColor(Color.GREEN);
        g.drawCircle(200, 200, 25, p);

        super.draw(deltaTime, renderView, lock);
    }

    /**
     * Clean up initialized variables in this method
     */
    @Override
    public void onDestroy() {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onInvalidate() {

    }
}
