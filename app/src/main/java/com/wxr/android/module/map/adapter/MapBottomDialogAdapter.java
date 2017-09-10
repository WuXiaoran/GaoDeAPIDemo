package com.wxr.android.module.map.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.wxr.android.base.adapter.BaseBottomSheetAdpater;
import com.wxr.android.base.adapter.viewHolder.BaseViewHolder;

import java.util.List;

/**
 * Created by ran on 2017/9/5.
 */

public class MapBottomDialogAdapter extends BaseBottomSheetAdpater {

    private List<String> data;

    public MapBottomDialogAdapter(Context context) {
        super(context);
    }


    @Override
    public BaseViewHolder createCustomViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void bindCustomViewHolder(BaseViewHolder holder, int position) {

    }

    @Override
    public int getCustomViewType(int position) {
        return 0;
    }

}
