package com.example.pongactivity;

public class GameLogic {
    protected Bat mBat;
    protected Ball mBall;

    protected int mScore = 0;
    protected int mLives = 3;
    protected int mScreenX;
    protected int mScreenY;
    public Ball getmBall() {
        return mBall;
    }
    //This section must initialize the ball and bat so that a new game and be created.
    //I also had to set
    public GameLogic(int x, int y) {
        mScreenX = x;
        mScreenY = y;

        mBall = new Ball(x);
        mBat = new Bat(x,y);

        startNewGame();
    }
    //This is the same exact method that was in PongGame but is now in the GameLogic class
    //This makes it much easier to write as one statement in the PongGame class and much easier to understand

    public void startNewGame(){

        // Put the ball back to the starting position
            mBall.reset(mScreenX, mScreenY);
            mBat.reset(mScreenX, mScreenY);

        // Rest the score and the player's chances
        mScore = 0;
        mLives = 3;

    }

	//resume and pause can also join this class
}
