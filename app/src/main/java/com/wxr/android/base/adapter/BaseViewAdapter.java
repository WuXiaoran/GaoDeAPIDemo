package com.wxr.android.base.adapter;

import android.content.Context;

import com.wxr.android.base.adapter.viewHolder.BaseViewHolder;

import java.util.List;

/**
 * Created by ran on 2017/8/30.
 * RecyclerView.Adapter的扩展，点击事件低耦合化
 */

public abstract class BaseViewAdapter<M,VH extends BaseViewHolder> extends BaseAdapter<M,VH> {

    public BaseViewAdapter(Context context) {
        super(context);
    }

    public BaseViewAdapter(Context context, List<M> list) {
        super(context, list);
    }
}
