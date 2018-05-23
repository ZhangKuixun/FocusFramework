package com.zkx.focus.library.focusMap;

import android.view.View;

import com.zkx.focus.library.widget.interfaces.FocusControl;

/**
 * Created by zhangkuixun on 2017/7/7.
 */

public class FocusView extends FocusControl {
    /**
     * 当前控件
     */
    public View mView;

    public int getId() {
        return mView.getId();
    }

    enum direction {
        up, down, left, right
    }

    /**
     * 下一个控件
     */
    public void nextFocusId(direction direction, int newId) {
        switch (direction) {
            case up:
                mView.setNextFocusUpId(newId);
                break;
            case down:
                mView.setNextFocusDownId(newId);
                break;
            case left:
                mView.setNextFocusLeftId(newId);
                break;
            case right:
                mView.setNextFocusRightId(newId);
                break;
        }
    }


}
