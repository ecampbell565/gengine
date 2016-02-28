package com.gyroscopegames.gengine;

import com.gyroscopegames.gengine.Scenes.ExampleScene;
import com.gyroscopegames.gengine.engine.logic.Scene;
import com.gyroscopegames.gengine.engine.engine.SquaredGameActivity;

/**
 * Created by Eric R. Campbell on 1/23/2016.
 */
public class SquaredMain extends SquaredGameActivity {

    private boolean isFirstCreation;

    public static final String TAG = "SQUARED_MAIN";

    @Override
    public Scene getInitScene() {

        ExampleScene scene = new ExampleScene(this);

        if(isFirstCreation) {
            //load assets
            isFirstCreation = false;
        }

        return scene;
    }
}
