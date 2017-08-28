package com.wxr.android.base;

import android.os.Bundle;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.wxr.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ran on 2017/8/26.
 */

public abstract class GaoDeBaseActivity extends BaseActivity{

    public AMap aMap;

    @BindView(R.id.map)
    MapView map;

    @Override
    protected void initOther() {
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_map;
    }

    @Override
    protected void initData() {
        if (aMap == null)
            aMap = map.getMap();
        store();
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

    /**
     * 数据源
     */
    protected abstract void store();
}
