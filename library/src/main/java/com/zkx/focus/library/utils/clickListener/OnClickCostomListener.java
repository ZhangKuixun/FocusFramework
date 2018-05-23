package com.zkx.focus.library.utils.clickListener;

import android.view.View;

/**
 * Created by zhangkuixun on 2017/8/26.
 * 点击事件执行之前定制化执行逻辑
 */
public abstract class OnClickCostomListener extends BaseClickListener {

    @Override
    public void onClick(View view) {
        super.onClick(view);

        if (isCorrect()) {
            onCorrentClick(view);
        } else {
            onNoCorrentClick(view);
        }
    }

    /**
     * 判断是否逻辑通过
     *
     * @return true=通过,false=未通过
     */
    public abstract boolean isCorrect();

    /**
     * 判断正确之后执行的逻辑请求
     *
     * @param v
     */
    public abstract void onCorrentClick(View v);

    /**
     * 判断失败之后执行的逻辑请求
     *
     * @param v
     */
    public abstract void onNoCorrentClick(View v);
}
