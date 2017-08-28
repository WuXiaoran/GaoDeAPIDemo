package com.wxr.android.module.map;

import android.graphics.BitmapFactory;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.wxr.android.R;
import com.wxr.android.base.GaoDeBaseActivity;

import java.util.Date;

/**
 * Created by ran on 2017/8/26.
 */

public class GaoDeMapActivity extends GaoDeBaseActivity implements AMapLocationListener {

    private AMap aMap;
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;


    @Override
    protected void store() {
        initMap();
    }

    private void initMap(){
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);
        myLocationStyle.interval(2000);
        aMap.setMyLocationStyle(myLocationStyle);
        aMap.setMyLocationEnabled(true);
        aMap.showIndoorMap(true);
        aMap.getUiSettings().setScaleControlsEnabled(true);

        MarkerOptions markerOption = new MarkerOptions();
        markerOption.position(new LatLng(113.2759952545166,23.117055306224895));
        markerOption.title("广州").snippet("当前位置");
        markerOption.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                .decodeResource(getResources(),R.mipmap.ic_launcher)));
        markerOption.draggable(true);//设置Marker可拖动
        // 将Marker设置为贴地显示，可以双指下拉地图查看效果
        markerOption.setFlat(true);//设置marker平贴地图效果

        mlocationClient = new AMapLocationClient(this);
        mLocationOption = new AMapLocationClientOption();
        mlocationClient.setLocationListener(this);
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setInterval(2000);
        mlocationClient.setLocationOption(mLocationOption);
        mlocationClient.startLocation();
    }


    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null){
            if (aMapLocation.getErrorCode() == 0){
                aMapLocation.getLocationType();
                aMapLocation.getAccuracy();

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(aMapLocation.getTime());
                df.format(date);
            }else{
                Log.e("AmapError","location Error, ErrCode:"
                        + aMapLocation.getErrorCode() + ", errInfo:"
                        + aMapLocation.getErrorInfo());
            }
        }
    }

    @Override
    protected void getBundleData(Bundle bundle) {

    }

    @Override
    protected void initWindow() {

    }

    @Override
    protected void initWidget() {

    }
}
