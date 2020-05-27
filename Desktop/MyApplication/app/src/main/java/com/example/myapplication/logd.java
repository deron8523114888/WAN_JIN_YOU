package com.example.myapplication;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

public class logd extends Activity {

    public void logd(Activity activity , String text){
        Log.d(activity.getLocalClassName(), text);
    }

}
