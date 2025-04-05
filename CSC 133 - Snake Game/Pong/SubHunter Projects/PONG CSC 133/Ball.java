package com.example.pongactivity;

import android.graphics.RectF;

class Ball extends GameObject{

    Ball(int screenX){
        super();
        // Make the ball square and 1% of screen width
        // of the screen width
        mBallWidth = screenX / 100;
        mBallHeight = screenX / 100;

        // Initialize the RectF with 0, 0, 0, 0
        // We do it here because we only want to
        // do it once.
        // WE will initialize the detail
        // at the start of each game
        mRect = new RectF();
    }

    public void update(long fps) {
        //This takes the default update method from the GameObjecty Class and greatly simplfiies the code
        super.update(fps);

    }


}