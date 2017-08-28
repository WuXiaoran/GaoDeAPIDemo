package com.wxr.android.module.main;

import android.os.Bundle;
import android.widget.Button;

import com.wxr.android.R;
import com.wxr.android.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ran on 2017/5/10.
 */

public class MainActivity extends BaseActivity{

    @BindView(R.id.btn_map)
    Button gotoMap;


    @Override
    protected void getBundleData(Bundle bundle) {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initWindow() {

    }

    @Override
    protected void initWidget() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.btn_map})
    public void gotoActivity(Button btn){
        switch (btn.getId()){
            case R.id.btn_map:
                break;
        }
    }
}
