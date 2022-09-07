package com.reactnativebackgroundthread;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.module.annotations.ReactModule;

import android.util.Log;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;



@ReactModule(name = BackgroundThreadModule.NAME)
public class BackgroundThreadModule extends ReactContextBaseJavaModule {
    public static final String NAME = "BackgroundThread";

    public BackgroundThreadModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }



    @ReactMethod
    public void runInBackground_withPriority( String threadPriority, final Callback callback){

// MAX for maximum thread priority = 10
// MIN for maximum thread priority = 1
// NORMAL for maximum thread priority = 5

        BackgroundThread th = new BackgroundThread(callback);

        switch (threadPriority){
            case "MAX":{
                th.setPriority(Thread.MAX_PRIORITY);
                break;
            }

            case "MIN":{
                th.setPriority(Thread.MIN_PRIORITY);
                break;
            }

            case "NORMAL":

            default:{
                th.setPriority(Thread.NORM_PRIORITY);
                break;
            }
        }

        Log.d("BackgroundThread_1 ", "run: "+th.getPriority());
        th.start();

    }


    @ReactMethod
    public void runInBackground(final Callback callback){

        this.runInBackground_withPriority("MAX",callback);
    }

    @NonNull
    @Override
    public String getName() {
        return MODULE_NAME;
    }

}
