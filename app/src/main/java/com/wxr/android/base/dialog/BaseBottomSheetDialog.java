package com.wxr.android.base.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.design.widget.BottomSheetDialog;

/**
 * Created by ran on 2017/8/30.
 */

public class BaseBottomSheetDialog extends BottomSheetDialog {


    public BaseBottomSheetDialog(@NonNull Context context) {
        super(context);
    }

    public BaseBottomSheetDialog(@NonNull Context context, @StyleRes int theme) {
        super(context, theme);
    }

    protected BaseBottomSheetDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
