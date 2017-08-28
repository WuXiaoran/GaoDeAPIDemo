package com.wxr.android;

import android.app.Application;


/**
 * App Application
 * Created by chang on 2017/2/23.
 */
public class AppContext extends Application {

    public static String[] PERMISSIONS = {""};

    @Override
    public void onCreate() {
        super.onCreate();
        initPermission();
    }

    /**
     * 请求私隐权限
     */
    private void initPermission() {
        PERMISSIONS = new String[]{"android.permission.READ_PHONE_STATE",
                "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"};
    }

}
