package com.gyroscopegames.gengine.engine.ui;

import android.view.View;
import java.util.List;

/**
 * Created by Eric R. Campbell on 1/22/2016.
 * Provides literally the exact same methods as input...
 */
public interface TouchListener extends View.OnTouchListener {

    /**
     * Returns whether the specified touch event is down
     * @param pointer   Corresponds to the pointer of the desired touch event
     * @return          Returns a boolean specifying whether touch even is touch down
     */
    public boolean isTouchDown(int pointer);

    /**
     * Returns the x value of the specified touch event
     * @param pointer   Corresponds to the pointer of the desired touch event
     * @return          Returns x value as int
     */
    public int getTouchX(int pointer);

    /**
     * Returns the y value of the specified touch event
     * @param pointer   Corresponds to the pointer of the desired touch event
     * @return          Returns y value as int
     */
    public int getTouchY(int pointer);

    /**
     * Provides access to the Touch Events currently being evaluated by MultiTouchHandler
     * @return          A List of touch events
     */
    public List<Input.TouchEvent> getTouchEvents();

}
