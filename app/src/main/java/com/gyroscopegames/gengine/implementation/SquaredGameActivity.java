package com.gyroscopegames.gengine.implementation;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import com.gyroscopegames.gengine.GameObjects.GameObject;
import com.gyroscopegames.gengine.GameObjects.implementation.Player;
import com.gyroscopegames.gengine.SquaredMain;
import com.gyroscopegames.gengine.engine.Game;
import com.gyroscopegames.gengine.engine.database.Database;
import com.gyroscopegames.gengine.engine.logic.LogicUpdater;
import com.gyroscopegames.gengine.engine.logic.Scene;
import com.gyroscopegames.gengine.engine.logic.StateController;
import com.gyroscopegames.gengine.engine.logic.UIListener;
import com.gyroscopegames.gengine.engine.ui.Graphics;
import com.gyroscopegames.gengine.engine.ui.Input;
import com.gyroscopegames.gengine.implementation.ui.AndroidInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Eric R. Campbell on 12/30/2015.
 */
public abstract class SquaredGameActivity extends Activity implements Game {

    private SquaredRenderView renderView;
    //private SquaredDatabaseEngine databaseEngine;
    private List<UIListener> eventHandlers;
    private SquaredLogicEngine logicEngine;
    private Scene currentScene;
    private Player clientPlayer;
    private Player opponent;
    private SquaredGraphics graphics;
    private Input input;
    private ExecutorService taskExecutor;
    private StateController stateController;

    protected HashMap<GameObject.ObjectType, GameObject> gameObjects;

    public static final String TAG = "SQUARED_CLASS_BASE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "Beginning of onCreate method");

        int bufferWidth = 800;
        int bufferHeight = 1200;
        Bitmap buffer = Bitmap.createBitmap(bufferWidth, bufferHeight, Bitmap.Config.ARGB_8888);
        Log.d(SquaredMain.TAG, "Buffer from SquaredGameActivity: " + buffer.toString());

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        float scaleX = (float) bufferWidth/ metrics.widthPixels;
        float scaleY = (float) bufferHeight / metrics.heightPixels;

        gameObjects = new HashMap<>();

        stateController = new StateController();
        eventHandlers = new ArrayList<>();
        logicEngine = new SquaredLogicEngine(this);
        graphics = new SquaredGraphics(this, buffer);
        currentScene = getInitScene();

        //Intent i = this.getIntent();
        //Bundle initInfo = i.getExtras();
        //boolean isSinglePlayer = initInfo.getBoolean("isSinglePlayer");

        taskExecutor = Executors.newFixedThreadPool(2);
        renderView = new SquaredRenderView(this);
        input = new AndroidInput(this, renderView, scaleX, scaleY);

        /**
         * player should be prompted to set up an account at the start of the application, when
         * the player matches up with an opponent, the uuid [and username] should be retrieved,
         * possibly the clientPlayer instance should also be retrieved from the database after initial
         * submission on the primary screen of the application before starting the game
         */
        clientPlayer = new Player(); //some database action should be taken to store player's uuid
        //opponent = databaseEngine.getPlayerInformation(PlayerUUID opponentId);

        /*if(isSinglePlayer) {
            opponent = null;
            configureSinglePlayer();
        }*/

        setContentView(renderView);
        Log.d(TAG, "End of onCreate method callback");
    }

    @Override
    public Database getDatabaseObject() {
        return null;
    }

    @Override
    public Scene getCurrentScene() {
        return this.currentScene;
    }

    @Override
    public List<UIListener> getEventListeners() {
        return eventHandlers;
    }

    @Override
    public Player.PlayerUUID getUserId() {
        return clientPlayer.getPlayerId();
    }

    @Override
    public Player.PlayerUUID getOpponentId() {
        return opponent == null ? null : opponent.getPlayerId();
    }

    @Override
    public LogicUpdater getLogicUpdater() {
        return this.logicEngine;
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void changeScene(Scene newScene) {
        this.currentScene.onDestroy();
        this.currentScene = newScene;
    }

    @Override
    public void addUIListener(UIListener listener) {
        this.eventHandlers.add(listener);
    }

    public void configureSinglePlayer() {

    }

    @Override
    public Graphics getGraphics() {
        return this.graphics;
    }

    @Override
    public StateController getStateController() {
        return null;
    }

    @Override
    public Input getInput() {
        return this.input;
    }

    @Override
    public ExecutorService getTaskExecutor() {
        return this.taskExecutor;
    }

    @Override
    public Resources getRes() {
        return this.getResources();
    }

    @Override
    public synchronized HashMap<GameObject.ObjectType, GameObject> getGameObjects() {
        return this.gameObjects;
    }

    @Override
    public void addGameObject(GameObject.ObjectType type, GameObject object) {
        this.gameObjects.put(type, object);
    }
}
