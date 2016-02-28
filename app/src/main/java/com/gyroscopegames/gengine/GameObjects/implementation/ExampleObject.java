package com.gyroscopegames.gengine.GameObjects.implementation;

import com.gyroscopegames.gengine.engine.logic.GameObject;

/**
 * Created by Eric R. Campbell on 2/7/2016.
 */
public class ExampleObject extends GameObject {

    private int mPositionX;
    private int mPositionY;
    private float mHorizSpeed;
    private float mVertSpeed;

    public ExampleObject() {
        mPositionX = 0;
        mPositionY = 0;
        mHorizSpeed = 1;
        mVertSpeed = 1;
    }

    @Override
    public void update(float deltaTime) {
        mPositionX += (mHorizSpeed * deltaTime);
        mPositionY += (mVertSpeed * deltaTime);
    }

    @Override
    public void draw() {

    }

    public int getPositionX() {
        return mPositionX;
    }

    public int getPositionY() {
        return mPositionY;
    }
}
