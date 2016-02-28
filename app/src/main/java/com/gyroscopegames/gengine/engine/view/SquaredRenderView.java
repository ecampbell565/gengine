package com.gyroscopegames.gengine.engine.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.gyroscopegames.gengine.engine.engine.Game;
import com.gyroscopegames.gengine.engine.engine.SquaredGameActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Eric R. Campbell on 12/30/2015.
 * Class needs some style cleanup
 * Causing some inflation errors
 * TODO some flickering is still occurring at start of application, possibly try a loading screen
 *
 */
public class SquaredRenderView extends SurfaceView implements Runnable, SurfaceHolder.Callback { //implements runnable?

    private Game game;
    private boolean running = false;
    private SurfaceHolder holder;
    private ExecutorService executor;
    private Thread renderThread;

    public static final String TAG = "RENDER_VIEW";

    private SquaredRenderView objectLock;

    public static final Object lock = new Object();

    public AtomicBoolean logicFinished = new AtomicBoolean(false);
    public AtomicBoolean sceneFinished = new AtomicBoolean(false);

    public SquaredRenderView(Game game) {
        super((Context) game);
        init(game);
    }

    public SquaredRenderView(SquaredGameActivity game, AttributeSet attrs) {
        super(game, attrs);
        init(game);
    }

    public SquaredRenderView(SquaredGameActivity game, AttributeSet attrs, int defStyle) {
        super(game, attrs, defStyle);
        init(game);
    }

    private void init(Game game) { //getGraphics and getTaskExecutor are returning null values??
        Log.i(TAG, "Init function called");
        this.game = game;
        executor = this.game.getTaskExecutor();

        holder = this.getHolder();
        holder.addCallback(this);

        objectLock = this;
    }

    public void setRunning(boolean b) {
        this.running = b;
    }

    @Override
    public void run() {
        final Rect dstRect = new Rect();
        long startTime = System.nanoTime();
        Log.d(TAG, "run() function called");

        while(running) {
            if(!holder.getSurface().isValid() || game==null || executor==null)
                continue;

            final float deltaTime = (System.nanoTime() - startTime) / 1000000.0f;
            startTime = System.nanoTime();

            final Canvas canvas = holder.lockCanvas();
            Log.i(TAG, "Canvas locked from holder");
            canvas.getClipBounds(dstRect);

            for(TASK task : TASK.values()) { //The end of these two commands aren't synched with unlockCanvasAndPost() call
                switch(task) {
                    case SCENE_TASK:
                        executor.execute(new Runnable() {
                            @Override
                            public void run() {
                                game.getCurrentScene().update(deltaTime);
                                game.getCurrentScene().draw(deltaTime, objectLock, lock);

                                Canvas buffer = new Canvas(game.getGraphics().getFrameBuffer()); //cleanup
                                canvas.drawBitmap(game.getGraphics().getFrameBuffer(), null, dstRect, null);

                                Log.i(TAG, "SysTime after SCENE_TASK executed: " + System.currentTimeMillis());
                            }
                        });
                        break;
                    case LOGIC_TASK:
                        executor.execute(new Runnable() {
                            @Override
                            public void run() {
                                game.getLogicUpdater().update(deltaTime, objectLock, lock);
                            }
                        });
                        break;
                    default:
                        System.exit(0);
                        break;
                }
            }
            synchronized (lock) { //TODO add third graphics buffer in case of locking timeout
                while(!(logicFinished.get() && sceneFinished.get())) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            Log.d(TAG, "canvas has been drawn");
            holder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d(TAG, "Surface created");
        renderThread = new Thread(this);
        this.setRunning(true);
        renderThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        executor.shutdownNow();
        this.setRunning(false);
        try {
            renderThread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Contains all the tasks that need to be executed by the task executor,
     * will be looped through and all executed at the same time
     */
    public enum TASK {
        SCENE_TASK, LOGIC_TASK
    }
}
