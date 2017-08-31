package com.wxr.android.base.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.wxr.android.base.adapter.viewHolder.BaseViewHolder;

/**
 * Created by Administrator on 2017/8/30.
 */

public abstract class BaseBottomSheetAdpater<M,VH extends BaseViewHolder> extends BaseAdapter<M,VH>{

    public BaseBottomSheetAdpater(Context context) {
        super(context);
    }

    @Override
    public VH createCustomViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void bindCustomViewHolder(VH holder, int position) {

    }

    @Override
    public int getCustomViewType(int position) {
        return 0;
    }
}
