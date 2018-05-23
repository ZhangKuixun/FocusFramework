package com.zkx.focus.library.widget.viewGroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;


/**
 * Created by zhangkuixun on 2017/7/4.
 */

public class TVLinearLayout extends LinearLayout {

    private View mRightView;
    private View mUpView;
    private View mLeftView;
    private View mDownView;

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

    public TVLinearLayout(Context context) {
        this(context, null);
    }

    public TVLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TVLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
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
}
