package com.gyroscopegames.gengine.implementation.ui;

import android.content.Context;
import android.os.Build;
import android.view.View;

import com.gyroscopegames.gengine.engine.ui.Input;
import com.gyroscopegames.gengine.engine.ui.TouchListener;

import java.util.List;

/**
 * Created by Eric R. Campbell on 1/22/2016.
 */
public class AndroidInput implements Input {

    TouchListener touchHandler;

    public AndroidInput(Context context, View view, float scaleX, float scaleY) {
        touchHandler = new MultiTouchHandler(view, scaleX, scaleY);
    }

    @Override
    public boolean isTouchDown(int pointer) {
        return touchHandler.isTouchDown(pointer);
    }

    @Override
    public int getTouchX(int pointer) {
        return touchHandler.getTouchX(pointer);
    }

    @Override
    public int getTouchY(int pointer) {
        return touchHandler.getTouchY(pointer);
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        return touchHandler.getTouchEvents();
    }
}
