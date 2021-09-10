package com.example.david.gifdavid;

import android.graphics.Bitmap;

/**
 * Created by david on 2018/10/12.
 */
//gif  ------》native    java
public class GifHandler {
    private long gifAddr;
    static {
        System.loadLibrary("native-lib");
    }
    public GifHandler(String path) {
        gifAddr=loadPath(path);
    }

    public native long loadPath(String path) ;

    public native int getWidth(long ndkGif);
    public native int getHeight(long ndkGif);
    public native int updateFrame(long ndkGif, Bitmap bitmap);
    public native int realse(long ndkGif);
    public int getWidth() {
        return  getWidth(gifAddr);
    }

    public int getHeight() {
     return    getHeight(gifAddr);
    }

    public int updateFrame(Bitmap bitmap) {
       return updateFrame(gifAddr, bitmap);
    }
}
