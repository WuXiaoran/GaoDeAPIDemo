package com.wxr.android.module.map.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.wxr.android.R;
import com.wxr.android.data.model.ViewMapEntity;

import java.util.List;

/**
 * Created by ran on 2017/9/10.
 */

public class MapBottomDialog extends BottomSheetDialog {

    private Context context;

    public MapBottomDialog(@NonNull Context context, List<ViewMapEntity> dataList) {
        super(context);
        this.context = context;
        initView(dataList);
    }

    public MapBottomDialog(@NonNull Context context, @StyleRes int theme) {
        super(context, theme);
    }

    public MapBottomDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    private void initView(List<ViewMapEntity> dataList) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_mapbottom,null);
        setContentView(view);
    }
}
