package com.zkx.focus.library.widget.interfaces;

import android.view.View;

import com.zkx.focus.library.widget.controlLibrary.data.Composition;

/**
 * Created by zhangkuixun on 2017/8/14.
 * 按{@link type}类型创建控件
 */

public interface BaseView {

    enum type {Button, TextView, ImageView}

    /**
     * 按类型创建控件
     *
     * @param type {@link type}
     * @param data 控件排版数据
     * @return 返回创建的控件
     */
    View ContentType(type type, Composition data);

}
