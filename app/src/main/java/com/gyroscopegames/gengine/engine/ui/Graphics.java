package com.gyroscopegames.gengine.engine.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Used to modify the frameBuffer, which is drawn onto the canvas after the surface of the mainView is
 * invalidated, one common object of this class should be made, so as to purpose the use
 * of synchronized methods
 * Created by Eric R. Campbell on 12/31/2015.
 */
public interface Graphics {

    /**
     * Draws a Bitmap directly on the frameBuffer, recall that the frameBuffer is only 800X1200
     * x and y values will be scaled in the SquaredRenderView class
     * @param bitmap    The bitmap to be drawn to the screen
     * @param x         The x position of the bitmap, will be scaled accordingly
     * @param y         The y position of the bitmap, will be scaled accordingly
     */
    public void drawBitmap(Bitmap bitmap, int x, int y);

    /**
     * Method to retrieve the frameBuffer contained in the Graphics class, not
     * an example of best principles, should be obsoleted and replaced with a
     * similar method in the Game interface
     * @return          The frameBuffer Bitmap
     */
    public Bitmap getFrameBuffer();

    /**
     * Draws a circle to the coordinates given
     * @param x         The center x position of the circle to be drawn, scaled accordingly
     * @param y         The center y position of the circle to be drawn
     * @param radius    The radius of the circle to be drawn
     * @param p         The color of the circle, if the color value is null, the
     *                  circle will not be drawn
     */
    public void drawCircle(float x, float y, float radius, Paint p);

    /**
     * Draws a color fullscreen
     * @param color     The color to be drawn into the entire screen
     */
    public void drawColor(int color);

}
