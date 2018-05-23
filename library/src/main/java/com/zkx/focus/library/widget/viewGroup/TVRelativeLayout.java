package com.zkx.focus.library.widget.viewGroup;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.List;


/**
 * Created by zhangkuixun on 2017/7/4.
 */

public class TVRelativeLayout extends RelativeLayout {

    private View mRightView;
    private View mUpView;
    private View mLeftView;
    private View mDownView;
    private List<View> mAllChildViews;

    public TVRelativeLayout(Context context) {
        this(context, null);
    }

    public TVRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TVRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
//        mAllChildViews = LayoutUtils.getAllChildViews(this);
//        Button button = new Button(getContext());
//        LayoutParams params = new LayoutParams(900, 200);
//        button.setLayoutParams(params);
//        addView(button);
//
//        Button button1 = new Button(getContext());
//        LayoutParams params1 = new LayoutParams(100, 100);
//        button1.setLayoutParams(params1);
//        params1.leftMargin = 900;
////        button1.setX(900);
//        addView(button1);
//
//        button.setFocusable(true);
//        button1.setFocusable(true);
    }

    /**
     * @param child   需要获取焦点的控件
     * @param focused 当前获取焦点的控件
     */
    @Override
    public void requestChildFocus(View child, View focused) {
        super.requestChildFocus(child, focused);
    }

    @Override
    public void clearFocus() {
        super.clearFocus();
        for (View view : mAllChildViews) {
            if (view.hasFocusable())
                view.clearFocus();
        }
    }

    /**
     * 注册默认焦点
     *
     * @param focusView 需要获取焦点的控件
     */
    public void requestDefaultFocus(View focusView) {
        for (View view : mAllChildViews) {
            if (view == focusView) {
                if (focusView instanceof ViewGroup && focusView.isFocusable()) {
                    focusView.requestFocus();
                }
                if (focusView instanceof RecyclerView) {
                    ((TVRecyclerView) focusView).requestDefaultFocus((TVRecyclerView) focusView);
                }
            } else {
                if (view.hasFocusable())
                    view.clearFocus();
            }
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
            mLeftView = findFocus();
        } else if (keyCode == KeyEvent.KEYCODE_PAGE_UP) {
            mUpView = findFocus();
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            mRightView = findFocus();
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
            mDownView = findFocus();
        }
        return super.dispatchKeyEvent(event);
    }

    public View getRightView() {
        mDownView.requestFocus();
        return mRightView;
    }

    public View getUpView() {
        mDownView.requestFocus();
        return mUpView;
    }

    public View getLeftView() {
        mDownView.requestFocus();
        return mLeftView;
    }

    public View getDownView() {
        mDownView.requestFocus();
        return mDownView;
    }

}
