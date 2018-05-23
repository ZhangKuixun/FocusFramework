package com.zkx.focus.library.widget.controlLibrary;

import android.view.View;
import android.widget.FrameLayout;

import com.zkx.focus.library.widget.controlLibrary.data.Composition;
import com.zkx.focus.library.widget.controlLibrary.data.CompositionStatic;

/**
 * Created by zhangkuixun on 2017/8/18.
 * 控件公用方法
 */
class ControlMethod {

    private View mView;

    ControlMethod(View view) {
        mView = view;
    }

    public void composition(int screenWidth, int screenHeight, Composition data) {
        float w = (float) screenWidth / 1280;
        float h = (float) screenHeight / 720;
        int paramsW = (int) (CompositionStatic.wCell * data.getWCellNumber() * w);
        int paramsH = (int) (CompositionStatic.hCell * data.getHCellNumber() * h);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(paramsW, paramsH);
        params.leftMargin = (int) (data.getXStart() * CompositionStatic.wCell * w);
        params.topMargin = (int) (data.getYStart() * CompositionStatic.hCell * h);
        mView.setLayoutParams(params);
    }

    public void requestFocus() {
        mView.setFocusable(true);
        mView.setClickable(true);
        mView.setFocusableInTouchMode(true);
    }



}
