package com.gyroscopegames.gengine.engine.ui;

import android.view.MotionEvent;
import android.view.View;

import com.gyroscopegames.gengine.engine.engine.Game;
import com.gyroscopegames.gengine.GameObjects.implementation.Player;
import com.gyroscopegames.gengine.engine.logic.UIListener;

/**
 * Created by Eric R. Campbell on 12/30/2015.
 */
public class SquaredEventHandler implements UIListener {

    private Game game;
    private Player mainPlayer;
    private Player opponent;

    public SquaredEventHandler(Game game) { //TODO this should be handled by the logic engine, logic engine calls should be handled by the renderview
        this.game = game;
        mainPlayer = game.getDatabaseObject().getPlayerState(game.getUserId(), true, true); //todo wtf
        opponent = game.getDatabaseObject().getPlayerState(game.getOpponentId(), true, true);
    }

    @Override
    public void onTouchEvent(MotionEvent event, View v) {

    }

    @Override
    public void onClickEvent(View v) {

    }
}
