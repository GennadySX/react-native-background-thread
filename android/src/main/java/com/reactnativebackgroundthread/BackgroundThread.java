package com.reactnativebackgroundthread;

import com.facebook.react.bridge.Callback;

class BackgroundThread extends Thread implements Runnable{
    Callback callback;
    public BackgroundThread(Callback cb){
            this.callback = cb;
    }
    @Override
    public void run() {

        this.callback.invoke();
    }
}
