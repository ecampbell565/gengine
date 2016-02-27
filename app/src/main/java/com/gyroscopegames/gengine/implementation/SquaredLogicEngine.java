package com.gyroscopegames.gengine.implementation;

import android.util.Log;

import com.gyroscopegames.gengine.engine.Game;
import com.gyroscopegames.gengine.engine.logic.LogicUpdater;
import com.gyroscopegames.gengine.engine.logic.Scene;

/**
 * Created by Eric R. Campbell on 12/30/2015.
 */
public class SquaredLogicEngine implements LogicUpdater { //TODO: abstract this shit

    private Scene scene;
    private Game game;

    public final static String TAG = "LOGIC_ENGINE";

    public SquaredLogicEngine(Game game) {
        this.game = game;
        scene = game.getCurrentScene();
    }

    @Override
    public void update(float deltaTime, SquaredRenderView renderView, Object lock) { //logic not specific to level goes here
        Log.i(TAG, "update method called, sysTime: " + System.currentTimeMillis());

        renderView.logicFinished.set(true);
        synchronized (SquaredRenderView.lock) {
            lock.notifyAll();
        }
    }
}

