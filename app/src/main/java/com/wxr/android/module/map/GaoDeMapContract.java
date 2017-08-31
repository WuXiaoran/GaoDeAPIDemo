package com.wxr.android.module.map;

import android.support.v7.app.AppCompatActivity;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.maps.AMap;
import com.wxr.android.base.vp.BasePresenter;
import com.wxr.android.base.vp.BaseView;

/**
 * Created by ran on 2017/8/30.
 */

public interface GaoDeMapContract {

    interface View extends BaseView<Presenter>{
        /**
         * 获取activity实例
         */
        AppCompatActivity getActivity();
    }

    interface Presenter extends BasePresenter{
        /**
         * 基本功能
         * @param aMap
         */
        void baseFunction(AMap aMap);

        /**
         * 地址信息改变事件
         * @param mlocationClient
         * @param mLocationOption
         */
        void locationChange(AMapLocationClient mlocationClient, AMapLocationClientOption mLocationOption);
    }

}
