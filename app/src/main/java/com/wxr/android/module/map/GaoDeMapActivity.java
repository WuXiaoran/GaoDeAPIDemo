package com.wxr.android.module.map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.wxr.android.R;
import com.wxr.android.base.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ran on 2017/8/26.
 */

public class GaoDeMapActivity extends BaseActivity implements GaoDeMapContract.View {

    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;
    private GaoDeMapContract.Presenter presenter;
    public AMap aMap;

    @BindView(R.id.map)
    MapView map;


    @Override
    protected void initOther(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        //必需配置
        map.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_map;
    }

    @Override
    protected void initData() {
        new GaoDeMapPresenter(this);
        if (aMap == null)
            aMap = map.getMap();
        initMap();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        map.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        map.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        map.onSaveInstanceState(outState);
    }

    private void initMap(){
        presenter.baseFunction(aMap);
        presenter.locationChange(mlocationClient,mLocationOption);


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

    @Override
    public void setPresenter(GaoDeMapContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public AppCompatActivity getActivity() {
        return this;
    }
}
