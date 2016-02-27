package com.gyroscopegames.gengine.implementation;

import com.gyroscopegames.gengine.engine.Game;
import com.gyroscopegames.gengine.engine.database.Database;
import com.gyroscopegames.gengine.GameObjects.implementation.Player;

/**
 * Created by Eric R. Campbell on 12/30/2015.
 */
public class SquaredDatabaseEngine implements Database {

    private Game game;

    public SquaredDatabaseEngine(Game g) {
        game = g;
    }

    @Override
    public Player getPlayerState(Player.PlayerUUID id, boolean isCached, boolean isAsync) {

        return null;
    }

    @Override
    public Player getPlayerState(Player.Username name, boolean isCached, boolean isAsync) {

        return null;
    }

    @Override
    public Player.PlayerUUID getPlayerUUID(Player.Username name) {

        return null;
    }

    @Override
    public boolean addPlayer(Player.Username name) {

        return true;
    }

    @Override
    public int getPlayerHighscore(Player.PlayerUUID id) {

        return 0;
    }

    @Override
    public short getPlayerLocalRank(Player.PlayerUUID id, String country) {

        return 0;
    }

    @Override
    public short getPlayerLocalRank(Player.PlayerUUID id, String country, String state) {

        return 0;
    }

    @Override
    public short getPlayerGlobalRank(Player.PlayerUUID id) {

        return 0;
    }
}
