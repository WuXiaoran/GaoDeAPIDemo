package com.wxr.android.base.adapter;

import android.content.Context;

import com.wxr.android.base.adapter.viewHolder.BaseViewHolder;

/**
 * Created by Administrator on 2017/8/30.
 */

public abstract class BaseBottomSheetAdpater<M,VH extends BaseViewHolder> extends BaseAdapter<M,VH>{

    public BaseBottomSheetAdpater(Context context) {
        super(context);
    }

}
