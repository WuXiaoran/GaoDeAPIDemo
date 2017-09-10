package com.wxr.android.data.model;

import java.io.Serializable;

/**
 * Created by ran on 2017/9/10.
 */

public class ViewMapEntity implements Serializable {

    //图片地址
    private String picDrawable;
    //图片备注
    private String picRemark;

    public String getPicDrawable() {
        return picDrawable;
    }

    public void setPicDrawable(String picDrawable) {
        this.picDrawable = picDrawable;
    }

    public String getPicRemark() {
        return picRemark;
    }

    public void setPicRemark(String picRemark) {
        this.picRemark = picRemark;
    }
}
