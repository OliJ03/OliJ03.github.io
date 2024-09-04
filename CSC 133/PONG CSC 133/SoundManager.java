package com.example.pongactivity;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.util.Log;

import java.io.IOException;

public class SoundManager {
    protected SoundPool mSP;
    protected int mBeepID = -1;
    protected int mBoopID = -1;
    protected int mBopID = -1;
    protected int mMissID = -1;
    public void SoundBuilder(Context context) {

        Log.d("SoundManager", "Context: " + context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            mSP = new SoundPool.Builder()
                    .setMaxStreams(5)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            mSP = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
            //int soundId = mSP.load(context, R.raw.beep, 0);
        }
        Log.d("SoundManager", "Context: " + context);
	//This can be a seperate class, but would clear up more space in PongGame if it stays here
            try {
                AssetManager assetManager = context.getAssets();
                AssetFileDescriptor descriptor;

                descriptor = assetManager.openFd("beep.ogg");
                mBeepID = mSP.load(descriptor, 0);

                descriptor = assetManager.openFd("boop.ogg");
                mBoopID = mSP.load(descriptor, 0);

                descriptor = assetManager.openFd("bop.ogg");
                mBopID = mSP.load(descriptor, 0);

                descriptor = assetManager.openFd("miss.ogg");
                mMissID = mSP.load(descriptor, 0);
            } catch (IOException e) {
                Log.e("error", "failed to load sound files");
                Log.d("SoundManager", "Context: " + context);
            }

    }
    public void mBeepIdSound (){
        mSP.play(mBeepID, 1, 1, 0, 0, 1);
    }
    public void mBoopIdSound (){
        mSP.play(mBoopID, 1, 1, 0, 0, 1);
    }
    public void mBopIdSound (){
        mSP.play(mBopID, 1, 1, 0, 0, 1);
    }
    public void mMissIdSound (){
        mSP.play(mMissID, 1, 1, 0, 0, 1);
    }
}
