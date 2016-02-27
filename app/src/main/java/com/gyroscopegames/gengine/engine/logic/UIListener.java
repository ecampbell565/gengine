package com.gyroscopegames.gengine.engine.logic;

import android.view.MotionEvent;
import android.view.View;

/**
 * Couples events received by RenderView to the logic engines
 */
public interface UIListener { //TODO has been obsoleted by MultiTouchHandler

    public void onTouchEvent(MotionEvent event, View v);
    public void onClickEvent(View v);

}
