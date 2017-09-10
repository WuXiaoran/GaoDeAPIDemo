package com.wxr.android.base.adapter;

import android.content.Context;
import android.view.View;

import com.wxr.android.base.adapter.viewHolder.BaseViewHolder;

import java.util.List;

/**
 * Created by ran on 2017/8/30.
 * RecyclerView.Adapter的扩展，基本的点击事件
 */

public abstract class BaseViewAdapter<M,VH extends BaseViewHolder> extends BaseAdapter<M,VH> {

    private ItemClick itemClick;
    private ItemLongClick itemLongClick;

    public void setOnItemClick(ItemClick itemClick){
        this.itemClick = itemClick;
    }

    public void setItemLongClick(ItemLongClick itemLongClick){
        this.itemLongClick = itemLongClick;
    }

    public BaseViewAdapter(Context context) {
        super(context);
    }

    public BaseViewAdapter(Context context, List<M> list) {
        super(context, list);
    }

    @Override
    public void bindCustomViewHolder(VH holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.itemClick(v,position);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                itemLongClick.itemLongClick(v,position);
                return false;
            }
        });
    }


    public interface ItemClick{
        void itemClick(View v,int position);
    }

    public interface ItemLongClick{
        void itemLongClick(View v,int position);
    }
}
