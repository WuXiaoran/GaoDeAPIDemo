package com.wxr.android.base.adapter.viewHolder;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ran on 2017/8/30.
 * ViewHolder基类
 * BaseViewHolder只是view的缓存
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {

    //使用性能更高的SparseArray来存储View数组
    private SparseArray<View> viewArray;

    public BaseViewHolder(View itemView) {
        super(itemView);
        viewArray = new SparseArray<>();
    }

    /**
     * viewHolder构造器
     * @param parent    父类容器
     * @param resId     视图id
     */
    public BaseViewHolder(ViewGroup parent, @LayoutRes int resId){
        super(LayoutInflater.from(parent.getContext()).inflate(resId,parent,false));
        viewArray = new SparseArray<>();
    }

    /**
     * 获取holder布局中的子布局
     * @param viewId    子布局的Id
     * @param <T>       View的类型
     * @return          view
     */
    protected <T extends View>T getView(@IdRes int viewId){
        View view = viewArray.get(viewId);
        if (view == null){
            view = itemView.findViewById(viewId);
            viewArray.put(viewId,view);
        }
        return (T) view;
    }

    /**
     * 获取Context的实例
     * @return  context
     */
    protected Context getContext(){
        return itemView.getContext();
    }
}
