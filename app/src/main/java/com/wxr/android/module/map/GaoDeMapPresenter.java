package com.wxr.android.module.map;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MyLocationStyle;
import com.wxr.android.R;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/30.
 */

public class GaoDeMapPresenter implements GaoDeMapContract.Presenter,AMapLocationListener{

    private GaoDeMapContract.View view;
    private Context context;

    public GaoDeMapPresenter(GaoDeMapContract.View view) {
        context = view.getActivity();
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void baseFunction(AMap aMap) {
        //设置定位蓝点样式
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.arrow);
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);
        myLocationStyle.myLocationIcon(bitmapDescriptor);
        myLocationStyle.interval(2000);
        aMap.setMyLocationStyle(myLocationStyle);
        aMap.setMyLocationEnabled(true);
        //室内地图
        aMap.showIndoorMap(true);
        aMap.getUiSettings().setScaleControlsEnabled(true);

//        MarkerOptions markerOption = new MarkerOptions();
//        markerOption.position(new LatLng(113.2759952545166,23.117055306224895));
//        markerOption.title("广州").snippet("当前位置");
//        markerOption.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
//                .decodeResource(getResources(),R.mipmap.ic_launcher)));
//        markerOption.draggable(true);//设置Marker可拖动
//        // 将Marker设置为贴地显示，可以双指下拉地图查看效果
//        markerOption.setFlat(true);//设置marker平贴地图效果
    }

    @Override
    public void locationChange(AMapLocationClient mlocationClient, AMapLocationClientOption mLocationOption) {
        //监听位置信息改变
        mlocationClient = new AMapLocationClient(context);
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
}
