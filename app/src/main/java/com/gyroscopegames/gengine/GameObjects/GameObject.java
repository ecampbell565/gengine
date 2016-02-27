package com.gyroscopegames.gengine.GameObjects;

import java.util.UUID;

/**
 * Created by Eric R. Campbell on 2/7/2016.
 * When creating a new type of game object, whose states need to be
 * dynamically changed based on logic code, subclass this class
 */
public abstract class GameObject {
    public final UUID uuid = UUID.randomUUID();

    public abstract void update(float deltaTime);

    public abstract void draw();

    public static enum ObjectType {
        EXAMPLE1, EXAMPLE2, EXAMPLE3
    }
}
