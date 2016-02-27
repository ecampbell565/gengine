package com.gyroscopegames.gengine.GameObjects.implementation;

import java.util.UUID;

/**
 * Created by Eric R. Campbell on 12/30/2015.
 */
public class Player {

    private PlayerUUID playerId;
    private Username username;

    public Player(String username) {
        playerId = new PlayerUUID();
        this.username = new Username(username);
    }

    public Player() {
        playerId = new PlayerUUID();
    }

    public boolean idMatch(PlayerUUID playerUUID) {
        return playerUUID == playerId ? true : false;
    }

    public PlayerUUID getPlayerId() {
        return playerId;
    }

    /*
     * Acts as a wrapper class for UUID to provide additional security...
     */
    public class PlayerUUID {

        private UUID id;

        public PlayerUUID() {
            id = UUID.randomUUID();
        }

        public UUID getId() {
            return id;
        }

    }

    public class Username {

        private String user;

        public Username(String s) {
            user = s;
        }

        public String getUsername() {
            return user;
        }
    }

}
