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
        PERMISSIONS = new String[]{"android.permission.CALL_PHONE","android.permission.ACCESS_COARSE_LOCATION",
                "android.permission.ACCESS_FINE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE"};
    }

}
