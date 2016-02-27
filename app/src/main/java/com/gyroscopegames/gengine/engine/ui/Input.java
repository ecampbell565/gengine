package com.gyroscopegames.gengine.engine.ui;

import java.util.List;

/**
 * Processes input received by the holder for the SquaredRenderView object
 * Created by Eric R. Campbell on 1/22/2016.
 */
public interface Input {

    /**
     * Defines basic attributes for a received touch event
     *
     */
    public static class TouchEvent {
        public static final int TOUCH_DOWN = 0;
        public static final int TOUCH_UP = 1;
        public static final int TOUCH_DRAGGED = 2;
        public static final int TOUCH_HOLD =  3;

        public int type;
        public int x,y;
        public int pointer;
    }

    /**
     * Provides access to whether the user is touching
     * @param pointer   Corresponds to the int pointer for each of the touchEvents
     *                  stored in the buffer in MultiTouchHandler
     * @return          Returns whether the touch is touchDown
     */
    public boolean isTouchDown(int pointer);

    /**
     * Provides access to the x value of the touch event specified by the pointer
     * @param pointer   Corresponds to the int pointer for each of the touchEvents
     *                  stored in the buffer in MultiTouchHandler
     * @return          Returns the x value of the touch event as an int
     */
    public int getTouchX(int pointer);

    /**
     * Provides access to whether the user is touching
     * @param pointer   Corresponds to the int pointer for each of the touchEvents
     *                  stored in the buffer in MultiTouchHandler
     * @return          Returns y value of the touch event as an int
     */
    public int getTouchY(int pointer);

    /**
     * Provides access to the list of touch events being used
     * @return          Returns a List of touch events
     */
    public List<TouchEvent> getTouchEvents();
}
