package com.zkx.focus.library.widget.controlLibrary;

import android.content.Context;
import android.widget.ImageView;

import com.zkx.focus.library.widget.controlLibrary.data.Composition;
import com.zkx.focus.library.widget.controlLibrary.params.ImageParams;

/**
 * Created by ZhangKuixun on 2017/8/12.
 */

public class TVImageView extends ImageView {

    private final ControlMethod mControlMethod;

    public TVImageView(Context context, int i) {
        super(context);
        mControlMethod = new ControlMethod(this);
        mControlMethod.requestFocus();
        setId(i);
    }

    /**
     * 设置参数
     */
    public void setParams(ImageParams params) {
        setScaleType(ScaleType.FIT_XY);
        setImageResource(params.getBitmapResource());
        setBackgroundResource(params.getBackGroundResource());
    }

    /**
     * 排版
     *
     * @param screenWidth  控件宽度
     * @param screenHeight 控件高度
     * @param data         控件排版参数
     */
    public void composition(int screenWidth, int screenHeight, Composition data) {
        mControlMethod.composition(screenWidth, screenHeight, data);
    }
}
