package com.wxr.android.base.vp;

/**
 * Created by ran on 2017/8/30.
 * 视图基类
 */

public interface BaseView<T> {

    /**
     * 设置Presenter
     */
    void setPresenter(T presenter);
}
