package com.zkx.focus.library.utils.clickListener;

import android.app.Activity;
import android.view.View;

/**
 * Created by zhangkuixun on 2017/8/26.
 * 判断是否登录
 */
public abstract class OnClickLoginedListener extends BaseClickListener {

    private Activity context = null;


    public OnClickLoginedListener(Activity context) {
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);

        if (isLogined(context, view)) {
            onLoginedClick(view);
        } else {
            onNoLoginedClick(view);
        }
    }

    /**
     * 判断当前用户是否登录
     *
     * @param context
     * @param view
     * @return
     */
    public abstract boolean isLogined(Activity context, View view);

    /**
     * 用户登录之后执行的逻辑
     *
     * @param v
     */
    public abstract void onLoginedClick(View v);

    /**
     * 用户未登录执行点击事件
     */
    public abstract void onNoLoginedClick(View v);
}
