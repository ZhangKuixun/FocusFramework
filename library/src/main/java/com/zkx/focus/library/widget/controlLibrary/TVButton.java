package com.zkx.focus.library.widget.controlLibrary;

import android.content.Context;
import android.text.InputFilter;
import android.widget.Button;

import com.zkx.focus.library.widget.controlLibrary.data.Composition;
import com.zkx.focus.library.widget.controlLibrary.params.TextParams;

/**
 * Created by ZhangKuixun on 2017/8/12.
 */

public class TVButton extends Button {

    private final ControlMethod mControlMethod;

    public TVButton(Context context, int i) {
        super(context);
        mControlMethod = new ControlMethod(this);
        mControlMethod.requestFocus();
        setId(i);
    }

    /**
     * 设置参数
     */
    public void setParams(TextParams params) {
        setBackgroundResource(params.getBackgroundColor());
        setText(params.getText());
        setGravity(params.getGravity());
        setEllipsize(params.getEllipsize());
        if (params.getBackgroundColor() > 0)
            setBackgroundResource(params.getBackgroundColor());
        if (params.getTextSize() > 0)
            setTextSize(params.getTextSize());
        if (params.getTextColor() > 0)
            setTextColor(params.getTextColor());
        if (params.getLines() > 0)
            setMaxLines(params.getLines());
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(params.getLength())});
        if (params.getPadding() > 0) {
            setPadding(params.getPadding(), params.getPadding(), params.getPadding(), params.getPadding());
        } else {
            if (params.getPaddingLeft() > 0)
                setPadding(params.getPaddingLeft(), 0, 0, 0);
            if (params.getPaddingTop() > 0)
                setPadding(0, params.getPaddingTop(), 0, 0);
            if (params.getPaddingRight() > 0)
                setPadding(0, 0, params.getPaddingRight(), 0);
            if (params.getPaddingBottom() > 0)
                setPadding(0, 0, 0, params.getPaddingBottom());
        }
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