package com.zkx.focus.library.widget.interfaces;

import android.view.View;

/**
 * Created by zhangkuixun on 2017/7/31.
 */

public interface IFocus {

    /**
     * 向上
     */
    void toUp(View view);

    /**
     * 向下
     */
    void toDown(View view);

    /**
     * 向左
     */
    void toLeft(View view);

    /**
     * 向右
     */
    void toRight(View view);

    /**
     * 确定
     */
    void clickOk();

    /**
     * 返回
     */
    void ClickBack();
}
