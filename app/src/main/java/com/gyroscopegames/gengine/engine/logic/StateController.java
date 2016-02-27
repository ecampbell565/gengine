package com.gyroscopegames.gengine.engine.logic;

import java.util.ArrayList;
import java.util.List;

import com.gyroscopegames.gengine.GameObjects.GameObject;

/**
 * Created by Eric R. Campbell on 1/2/2016.
 */
public class StateController {

    private static List<GameObject> gameObjectList;

    public StateController() {
        gameObjectList = new ArrayList<>();
    }

    public void addGameObject(GameObject object) {
        gameObjectList.add(object);
    }

    public void updateAll(float deltaTime) {
        for(GameObject o : gameObjectList) {
            o.update(deltaTime);
        }
    }
}
