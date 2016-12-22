package com.example.lijunhui.drinktest;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lijunhui on 2016/11/14.
 */

public class sound extends AppCompatActivity{
    // SoundPool对象
    public static SoundPool mSoundPlayer = new SoundPool(10,
            AudioManager.STREAM_SYSTEM, 5);
    public static sound soundPlayUtils;
    // 上下文
    static Context mContext;

    /**
     * 初始化
     *
     * @param context
     */
    public static sound init(Context context) {
        if (soundPlayUtils == null) {
            soundPlayUtils = new sound();
        }

        // 初始化声音
        mContext = context;

        mSoundPlayer.load(mContext, R.raw.yp1, 1);// 1


        return soundPlayUtils;
    }

    /**
     * 播放声音
     *
     * @param soundID
     */
    public static void play(int soundID) {
        mSoundPlayer.play(soundID, 1, 1, 0, 0, 1);
    }

}
