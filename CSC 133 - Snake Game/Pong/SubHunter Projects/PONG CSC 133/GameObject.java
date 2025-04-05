package com.example.pongactivity;

import android.graphics.RectF;


//This class was created for inheritance for the bat and ball and any other Objects introduced into the game for the future.
//This helped GREATLY reduce the amount of code clutter in the Bat and Ball classes, and eliminated redundancies in my code.
abstract class GameObject  {
    protected RectF mRect;
    protected float mXVelocity;
    protected float mYVelocity;
    protected float mBallWidth;
    protected float mBallHeight;
    protected float mBatMoving;
    final int STOPPED = 0;
    final int LEFT = 1;
    final int RIGHT = 2;
    protected float mXCoord;
    protected float mYCoord;
    protected float mBatSpeed;
    protected int mScreenX;
    protected int mScreenY;
    protected float mLength;

    public GameObject() {
        mRect = new RectF();
        mXVelocity = 0;
        mYVelocity = 0;
    }

    public RectF getRect() {
        return mRect;
    }

    public float getmXVelocity() {
        return mXVelocity;
    }

    public float getmYVelocity() {
        return mYVelocity;
    }

    public void setmXVelocity(float velocity) {
        mXVelocity = velocity;
    }

    public void setmYVelocity(float velocity) {
        mYVelocity = velocity;
    }

    public void update(long fps) {
        // Move the ball based upon the
        // horizontal (mXVelocity) and
        // vertical(mYVelocity) speed
        // and the current frame rate(mFPS)

        // Move the top left corner
        mRect.left = mRect.left + (mXVelocity / fps);
        mRect.top = mRect.top + (mYVelocity / fps);

        // Match up the bottom right corner
        // based on the size of the ball
        mRect.right = mRect.left + mBallWidth;
        mRect.bottom = mRect.top + mBallHeight;

    }

    // Reverse the vertical direction of travel
    public void reverseYVelocity() {
        mYVelocity = -mYVelocity;
    }

    // Reverse the horizontal direction of travel
    public void reverseXVelocity() {
        mXVelocity = -mXVelocity;
    }

    public void setMovementState(int state) {
        mBatMoving = state;
    }

    public void batBounce(RectF batPosition) {

        // Detect center of bat
        float batCenter = batPosition.left +
                (batPosition.width() / 2);

        // detect the center of the ball
        float ballCenter = mRect.left +
                (mBallWidth / 2);

        // Where on the bat did the ball hit?
        float relativeIntersect = (batCenter - ballCenter);

        // Pick a bounce direction
        if (relativeIntersect < 0) {
            // Go right
            mXVelocity = Math.abs(mXVelocity);
            // Math.abs is a static method that
            // strips any negative values from a value.
            // So -1 becomes 1 and 1 stays as 1
        } else {
            // Go left
            mXVelocity = -Math.abs(mXVelocity);
        }

        // Having calculated left or right for
        // horizontal direction simply reverse the
        // vertical direction to go back up
        // the screen
        reverseYVelocity();
    }

    public void increaseVelocity() {
        // increase the speed by 10%
        mXVelocity = mXVelocity * 1.1f;
        mYVelocity = mYVelocity * 1.1f;
    }

    public void reset(int x, int y) {

        // Initialise the four points of
        // the rectangle which defines the ball
        mRect.left = x / 2;
        mRect.top = 0;
        mRect.right = x / 2 + mBallWidth;
        mRect.bottom = mBallHeight;

        // How fast will the ball travel
        // You could vary this to suit
        // You could even increase it as the game progresses
        // to make it harder
        mYVelocity = -(y / 3);
        mXVelocity = (y / 3);
    }
}


