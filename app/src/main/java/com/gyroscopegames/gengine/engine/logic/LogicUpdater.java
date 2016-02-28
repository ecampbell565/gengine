package com.gyroscopegames.gengine.engine.logic;

import com.gyroscopegames.gengine.engine.view.SquaredRenderView;

/**
 * Implementation of this class should be in a separate Thread
 * Created by Eric R. Campbell on 12/30/2015.
 */
public interface LogicUpdater {

    /**
     * Interact with GameObject states in this method, should only include logic
     * that is specific to the game itself, not level-specific logic
     * @param deltaTime     Provides the time passed between game cycles
     * @param renderView    Obsolete, needs removing
     * @param lock          Possibly obsolete, needs checking
     */
    public void update(float deltaTime, SquaredRenderView renderView, Object lock); //TODO interface needed for abstraction

}
