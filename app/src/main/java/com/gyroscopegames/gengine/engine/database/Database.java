package com.gyroscopegames.gengine.engine.database;

import com.gyroscopegames.gengine.GameObjects.implementation.Player;
import com.gyroscopegames.gengine.GameObjects.implementation.Player.Username;
import com.gyroscopegames.gengine.GameObjects.implementation.Player.PlayerUUID;

/**
 * Database interface for access to application information, most of these methods should be
 * implemented as async tasks
 * Created by Eric R. Campbell on 12/30/2015.
 */
public interface Database {

    /**
     * For these methods, if isCached, then results will be stored locally, so constant retrieval
     * from a database is unnecessary
     */
    public Player getPlayerState(PlayerUUID id, boolean isCached, boolean isAsync);

    public Player getPlayerState(Username name, boolean isCached, boolean isAsync);

    public PlayerUUID getPlayerUUID(Username name);

    /**
     * Adds a player to the database using only the name of the player, other parameters should be
     * initialized to their default value
     * @return          The success of the action
     */
    public boolean addPlayer(Username name);

    public int getPlayerHighscore(PlayerUUID id);

    /**
     * Use this method if target country is not divided into states
     * @param country   Target location by country, use 3-digit ISO code
     * @return          The player's rank within that country
     */
    public short getPlayerLocalRank(PlayerUUID id, String country);

    /**
     * Use this method if target country is divided into states, or possibly major provinces
     * Difference between these two methods is not necessarily concrete
     * @param country   Target country, use 3-digit ISO code
     * @param state     Target state/province within given country - check validation, use most standardized state code??!?
     * @return          The player's rank within that state/province
     */
    public short getPlayerLocalRank(PlayerUUID id, String country, String state);

    /**
     * @return          The player's global rank
     */
    public short getPlayerGlobalRank(PlayerUUID id);

}
