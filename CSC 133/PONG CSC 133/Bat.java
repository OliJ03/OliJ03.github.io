package com.example.pongactivity;

import android.graphics.RectF;

class Bat extends GameObject{

    Bat(int sx, int sy){
        super();
        // Bat needs to know the screen
        // horizontal resolution
        // Outside of this method
        mScreenX = sx;
        mScreenY = sy;

        // Configure the size of the bat based on
        // the screen resolution
        // One eighth the screen width
        mLength = mScreenX / 8;
        // One fortieth the screen height
        float height = mScreenY / 40;

        // Configure the starting locaion of the bat
        // Roughly the middle horizontally
        mXCoord = mScreenX / 2;
        mYCoord = mScreenY - height;
        // The height of the bat
        // off of the bottom of the screen
        float mYCoord = sy - height;

        // Initialize mRect based on the size and position
        mRect = new RectF(mXCoord, mYCoord,
                mXCoord + mLength,
                mYCoord + height);

        // Configure the speed of the bat
        // This code means the bat can cover the
        // width of the screen in 1 second
        mBatSpeed = mScreenX;
    }
    //bat needs to use Override in order to call a different update method to Ball, but this makes it much easier to read
    //and understand compared to before
    @Override
    public void update(long fps) {
        if(mBatMoving == LEFT){
            mXCoord = mXCoord - mBatSpeed / fps;
        }

        if(mBatMoving == RIGHT){
            mXCoord = mXCoord + mBatSpeed / fps;
        }

        // Stop the bat going off the screen
        if(mXCoord < 0){
            mXCoord = 0;
        }

        if(mXCoord + mLength > mScreenX){
            mXCoord = mScreenX - mLength;
        }

        // Update mRect based on the results from
        // the previous code in update
        mRect.left = mXCoord;
        mRect.right = mXCoord + mLength;
    }
    //Similar to update, reset needs overridde in order to use a different reset function. This however still makes this class
    //easier to read
    @Override
    public void reset(int x, int y) {
        mLength = x / 8;
        // One fortieth the screen height
        float height = y / 40;

        // Configure the starting locaion of the bat
        // Roughly the middle horizontally
        mXCoord = x / 2;
        mYCoord = y - height;
        // The height of the bat
        // off of the bottom of the screen
        float mYCoord = y - height;

        // Initialize mRect based on the size and position
        mRect = new RectF(mXCoord, mYCoord,
                mXCoord + mLength,
                mYCoord + height);

        // Configure the speed of the bat
        // This code means the bat can cover the
        // width of the screen in 1 second
        mBatSpeed = mScreenX;
    }

}