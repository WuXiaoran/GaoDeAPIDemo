package com.wxr.android.module.main;

import android.os.Bundle;
import android.widget.Button;

import com.wxr.android.R;
import com.wxr.android.base.activity.BaseActivity;
import com.wxr.android.module.map.GaoDeMapActivity;
import com.wxr.android.util.IntentUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
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
        return R.layout.activity_main;
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

    @Override
    protected void initOther(Bundle savedInstanceState) {
        ButterKnife.bind(this);
    }



    @OnClick({R.id.btn_map})
    public void gotoActivity(Button btn){
        switch (btn.getId()){
            case R.id.btn_map:
                IntentUtil.startActivity(this, GaoDeMapActivity.class);
                break;
        }
    }
}
