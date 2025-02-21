package com.example.pongactivity;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

class PongGame extends SurfaceView implements Runnable{
    // Are we debugging?
    private final boolean DEBUGGING = true;
    // These objects are needed to do the drawing
    private SurfaceHolder mOurHolder;
    private Canvas mCanvas;
    private Paint mPaint;
    // How many frames per second did we get?
    private long mFPS;
    // The number of milliseconds in a second
    private final int MILLIS_IN_SECOND = 1000;
    // Holds the resolution of the screen
    private int mScreenX;
    private int mScreenY;
    // How big will the text be?
    private int mFontSize;
    private int mFontMargin;
    // The game objects
    private Bat mBat;
    private Ball mBall;
    // The current score and lives remaining
    private int mScore = 0;
    private int mLives = 3;
    // Here is the Thread and two control variables
    private Thread mGameThread = null;
    // This volatile variable can be accessed
    // from inside and outside the thread
    private volatile boolean mPlaying;
    private boolean mPaused = true;
    // All these are for playing sounds
    private SoundManager soundManager;
    private GameLogic gameLogic;
    // The PongGame constructor
    // Called when this line:
    // mPongGame = new PongGame(this, size.x, size.y);
    // is executed from PongActivity
    public PongGame(Context context, int x, int y, GameLogic gameLogic, Ball ball) {
        // Super... calls the parent class
        // constructor of SurfaceView
        // provided by Android
        super(context);
        soundManager = new SoundManager();
        this.gameLogic = gameLogic;
        this.mBall = ball;

        //gameLogic = new GameLogic((PongActivity) context,x,y);
        // Initialize these two members/fields
        // With the values passesd in as parameters
        mScreenX = x;
        mScreenY = y;

        // Font is 5% (1/20th) of screen width
        mFontSize = mScreenX / 20;
        // Margin is 1.5% (1/75th) of screen width
        mFontMargin = mScreenX / 75;

        // Initialize the objects
        // ready for drawing with
        // getHolder is a method of SurfaceView
        mOurHolder = getHolder();
        mPaint = new Paint();

        // Initialize the bat and ball

        mBall = new Ball(mScreenX);
        mBat = new Bat(mScreenX, mScreenY);

        soundManager.SoundBuilder(context.getApplicationContext());
        gameLogic.startNewGame();
    }

    // When we start the thread with:
    // mGameThread.start();
    // the run method is continuously called by Android
    // because we implemented the Runnable interface
    // Calling mGameThread.join();
    // will stop the thread
   @Override
    public void run() {
        // mPlaying gives us finer control
        // rather than just relying on the calls to run
        // mPlaying must be true AND
        // the thread running for the main loop to execute
        while (mPlaying) {

            // What time is it now at the start of the loop?
            long frameStartTime = System.currentTimeMillis();

            // Provided the game isn't paused call the update method
            if(!mPaused){
                update(gameLogic);
                // Now the bat and ball are in their new positions
                // we can see if there have been any collisions
                detectCollisions(gameLogic);

            }

            // The movement has been handled and collisions
            // detected now we can draw the scene.
            draw();

            // How long did this frame/loop take?
            // Store the answer in timeThisFrame
            long timeThisFrame = System.currentTimeMillis() - frameStartTime;

            // Make sure timeThisFrame is at least 1 millisecond
            // because accidentally dividing by zero crashes the game
            if (timeThisFrame > 0) {
                // Store the current frame rate in mFPS
                // ready to pass to the update methods of
                // mBat and mBall next frame/loop
                mFPS = MILLIS_IN_SECOND / timeThisFrame;
            }

        }

    }

    void update(GameLogic gameLogic) {
        // Update the bat and the ball
        gameLogic.getmBall().update(mFPS);
        mBat.update(mFPS);
    }

    void detectCollisions(GameLogic gameLogic){
        // Has the bat hit the ball?
        if(RectF.intersects(mBat.getRect(), gameLogic.getmBall().getRect())) {
            // Realistic-ish bounce
            gameLogic.getmBall().batBounce(mBat.getRect());
            gameLogic.getmBall().increaseVelocity();
            gameLogic.mScore++;
            //mSP.play(mBeepID, 1, 1, 0, 0, 1);
            soundManager.mBeepIdSound();

        }

        // Has the ball hit the edge of the screen

        // Bottom
        if(gameLogic.getmBall().getRect().bottom > mScreenY){
            gameLogic.getmBall().reverseYVelocity();

            gameLogic.mLives--;
            //mSP.play(mMissID, 1, 1, 0, 0, 1);
            soundManager.mMissIdSound();

            if(gameLogic.mLives == 0){
                mPaused = true;
                //gameLogic.startNewGame();
                gameLogic.startNewGame();

            }
        }

        // Top
        if(gameLogic.getmBall().getRect().top < 0){
            gameLogic.getmBall().reverseYVelocity();
            //mSP.play(mBoopID, 1, 1, 0, 0, 1);
            soundManager.mBoopIdSound();
        }

        // Left
        if(gameLogic.getmBall().getRect().left < 0){
            gameLogic.getmBall().reverseXVelocity();
            //mSP.play(mBopID, 1, 1, 0, 0, 1);
            soundManager.mBopIdSound();
        }

        // Right
        if(gameLogic.getmBall().getRect().right > mScreenX){
            gameLogic.getmBall().reverseXVelocity();
            //mSP.play(mBopID, 1, 1, 0, 0, 1);
            soundManager.mBopIdSound();
        }

    }
//move to text class
    // Draw the game objects and the HUD
    void draw() {
        if (mOurHolder.getSurface().isValid()) {
            // Lock the canvas (graphics memory) ready to draw
            mCanvas = mOurHolder.lockCanvas();

            // Fill the screen with a solid color
            mCanvas.drawColor(Color.argb
                    (255, 26, 128, 182));

            // Choose a color to paint with
            mPaint.setColor(Color.argb
                    (255, 255, 255, 255));

            // Draw the bat and ball
            mCanvas.drawRect(gameLogic.getmBall().getRect(), mPaint);
            mCanvas.drawRect(mBat.getRect(), mPaint);

            // Choose the font size
            mPaint.setTextSize(mFontSize);

            // Draw the HUD
            mCanvas.drawText("Score: " + gameLogic.mScore +
                            "   Lives: " + gameLogic.mLives +
                            "                     Oliver Jezildzic", +
                    mFontMargin , mFontSize, mPaint);

            if(DEBUGGING){
                printDebuggingText();
            }
            // Display the drawing on screen
            // unlockCanvasAndPost is a method of SurfaceView
            mOurHolder.unlockCanvasAndPost(mCanvas);
        }

    }

    // Handle all the screen touches
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        // This switch block replaces the
        // if statement from the Sub Hunter game
        switch (motionEvent.getAction() &
                MotionEvent.ACTION_MASK) {

            // The player has put their finger on the screen
            case MotionEvent.ACTION_DOWN:

                // If the game was paused unpause
                mPaused = false;

                // Where did the touch happen
                if(motionEvent.getX() > mScreenX / 2){
                    // On the right hand side
                    mBat.setMovementState(mBat.RIGHT);
                }
                else{
                    // On the left hand side
                    mBat.setMovementState(mBat.LEFT);
                }

                break;

            // The player lifted their finger
            // from anywhere on screen.
            // It is possible to create bugs by using
            // multiple fingers. We will use more
            // complicated and robust touch handling
            // in later projects
            case MotionEvent.ACTION_UP:

                // Stop the bat moving
                mBat.setMovementState(mBat.STOPPED);
                break;
        }
        return true;
    }
//move to text class
    private void printDebuggingText(){
        int debugSize = mFontSize / 2;
        int debugStart = 150;
        mPaint.setTextSize(debugSize);
        mCanvas.drawText("FPS: " + mFPS ,
                10, debugStart + debugSize, mPaint);

    }
//move to GameLogic
    // This method is called by PongActivity
    // when the player quits the game
    public void pause() {
        // Set mPlaying to false
        // Stopping the thread isn't
        // always instant
        mPlaying = false;
        try {
            // Stop the thread
            mGameThread.join();
        } catch (InterruptedException e) {
            Log.e("Error:", "joining thread");
        }

    }
//move to GameLogic
    // This method is called by PongActivity
    // when the player starts the game
    public void resume() {
        mPlaying = true;
        // Initialize the instance of Thread
        mGameThread = new Thread(this);

        // Start the thread
        mGameThread.start();
    }
}