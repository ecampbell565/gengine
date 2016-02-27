package com.gyroscopegames.gengine.implementation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.gyroscopegames.gengine.engine.Game;
import com.gyroscopegames.gengine.engine.ui.Graphics;

/**
 * Created by Eric R. Campbell on 12/31/2015.
 */
public class SquaredGraphics implements Graphics {

    private Bitmap frameBuffer;
    private Game game;
    private Canvas workingCanvas;

    public static final String TAG = "SQUARED_GRAPHICS";

    public SquaredGraphics(Game game, Bitmap buffer) {
        frameBuffer = buffer;
        this.game = game;
        workingCanvas = new Canvas(frameBuffer);
    }

    @Override
    public synchronized void drawBitmap(Bitmap bitmap, int x, int y) {
        workingCanvas.drawBitmap(bitmap, x, y, null);
    }

    @Override
    public synchronized void drawCircle(float x, float y, float radius, Paint p) {
        Log.d(TAG, "drawCircle() called");
        Log.d(TAG, "value of frameBuffer: " + this.frameBuffer);
        workingCanvas.drawCircle(x, y, radius, p);

    }

    @Override
    public synchronized Bitmap getFrameBuffer() {
        Log.d(TAG, "getFrameBuffer() called, value of Bitmap returned: "  + this.frameBuffer);
        return this.frameBuffer;
    }

    @Override
    public synchronized void drawColor(int color) {
        workingCanvas.drawColor(color);
    }
}
